package ru.treejoy.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.treejoy.dao.services.CarAdService;
import ru.treejoy.dao.services.CityService;
import ru.treejoy.dao.services.ModelService;
import ru.treejoy.model.User;
import ru.treejoy.model.ad.CarAd;
import ru.treejoy.model.brands.Model;
import ru.treejoy.model.geo.City;
import ru.treejoy.model.parts.Body;
import ru.treejoy.model.parts.Motor;
import ru.treejoy.model.parts.Transmission;
import ru.treejoy.model.parts.WheelDrive;
import ru.treejoy.utils.ImageReSizer;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for creating car ad.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.04.2018
 */
@Controller
@RequestMapping("/createcarad")
public class CarAdController {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * CarAdService.
     */
    @Autowired
    private CarAdService carAdService;

    /**
     * CityService.
     */
    @Autowired
    private CityService cityService;

    /**
     * ModelService.
     */
    @Autowired
    private ModelService modelService;

    /**
     * Check user session.
     *
     * @param session http session.
     * @return part of url.
     */
    @GetMapping
    public String isLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            session.setAttribute("bodies", Body.toArrayString());
            session.setAttribute("motors", Motor.toArrayString());
            session.setAttribute("transmissions", Transmission.toArrayString());
            session.setAttribute("drives", WheelDrive.toArrayString());
            return "CreateCarAd";
        } else {
            return "LoginRequired";
        }
    }

    /**
     * Ad creation. Image saves to file system in two copies with different sizes.
     *
     * @param session      http session.
     * @param file         image.
     * @param city         id.
     * @param model        id.
     * @param year         of manufacture.
     * @param kilometers   on odometer.
     * @param body         type of car.
     * @param motor        type of car.
     * @param power        of motor.
     * @param transmission type of car.
     * @param drive        type of car.
     * @param description  about car.
     * @param price        of car.
     * @return part of url.
     */
    @PostMapping
    public String addCarAd(HttpSession session,
                           @RequestParam(value = "photo", required = false) MultipartFile file,
                           @RequestParam(value = "cities") String city, @RequestParam(value = "models") String model,
                           @RequestParam(value = "year") String year, @RequestParam(value = "kilo") String kilometers,
                           @RequestParam(value = "bodies") String body, @RequestParam(value = "motors") String motor,
                           @RequestParam(value = "power") String power,
                           @RequestParam(value = "transmissions") String transmission,
                           @RequestParam(value = "drives") String drive,
                           @RequestParam(value = "description", required = false) String description,
                           @RequestParam(value = "price") String price) {
        User creator = (User) session.getAttribute("user");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cities", city);
        parameters.put("models", model);
        parameters.put("year", year);
        parameters.put("kilo", kilometers);
        parameters.put("bodies", body);
        parameters.put("motors", motor);
        parameters.put("power", power);
        parameters.put("transmissions", transmission);
        parameters.put("drives", drive);
        parameters.put("description", description);
        parameters.put("price", price);

        ServletContext servletContext = session.getServletContext();
        List<String> images = new ArrayList<>();
        if (!file.isEmpty()) {
            long folder = creator.getId() % 26;
            try {
                String mainPath = servletContext.getRealPath("")
                        + "images" + File.separator + folder + File.separator + file.getOriginalFilename();
                images.add(folder + File.separator + file.getOriginalFilename());
                File mainFile = new File(mainPath);
                if (!mainFile.getParentFile().exists()) {
                    mainFile.getParentFile().mkdir();
                }
                mainFile.createNewFile();

                String smallPath = servletContext.getRealPath("") + "images" + File.separator
                        + "small" + File.separator + folder + File.separator + file.getOriginalFilename();
                File smallFile = new File(smallPath);
                if (!smallFile.getParentFile().exists()) {
                    smallFile.getParentFile().mkdir();
                }
                smallFile.createNewFile();
                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
                ImageReSizer reSizer = new ImageReSizer();
                BufferedImage mainBufferedImage = reSizer
                        .resize(800, 800, bufferedImage);
                BufferedImage smallBufferedImage = reSizer
                        .resize(200, 150, bufferedImage);
                ImageIO.write(mainBufferedImage, "JPEG", mainFile);
                ImageIO.write(smallBufferedImage, "JPEG", smallFile);
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        createCarAd(creator, parameters, images);
        return "Successad";
    }


    /**
     * Сar ad creation.
     *
     * @param creator    user.
     * @param parameters map with parameters for the ad.
     * @param images     list of uploaded images.
     */

    private void createCarAd(User creator, Map<String, String> parameters, List<String> images) {
        long cityId = Long.parseLong(parameters.get("cities"));
        long modelId = Long.parseLong(parameters.get("models"));
        int year = Integer.parseInt(parameters.get("year"));
        int kilo = Integer.parseInt(parameters.get("kilo"));
        Body body = Body.valueOf(parameters.get("bodies").toUpperCase());
        Motor motor = Motor.valueOf(parameters.get("motors").toUpperCase());
        int power = Integer.parseInt(parameters.get("power"));
        Transmission transmission = Transmission.valueOf(parameters.get("transmissions").toUpperCase());
        WheelDrive wheelDrive = WheelDrive.valueOf(parameters.get("drives").toUpperCase());
        String description = parameters.get("description");
        int price = Integer.parseInt(parameters.get("price"));
        City city = cityService.getByID(cityId);
        Model model = modelService.getByID(modelId);

        CarAd carAd = new CarAd();
        carAd.setCity(city);
        carAd.setImages(images);
        carAd.setPrice(BigInteger.valueOf(price));
        carAd.setStatus(false);
        carAd.setCreator(creator);
        if (description != null) {
            carAd.setDescription(description);
        }
        carAd.setModel(model);
        carAd.setTransmission(transmission);
        carAd.setMotor(motor);
        carAd.setBody(body);
        carAd.setYearOfManufacture(year);
        carAd.setKilometrage(kilo);
        carAd.setPower(power);
        carAd.setWheelDrive(wheelDrive);
        carAdService.create(carAd);
    }
}

