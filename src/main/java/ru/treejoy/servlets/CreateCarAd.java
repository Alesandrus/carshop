package ru.treejoy.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.CarAdDAO;
import ru.treejoy.dao.CityDAO;
import ru.treejoy.dao.ModelDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * Сервлет, отвечающий за создание объявления.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class CreateCarAd extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Проверка залогинен ли пользователь и передача соответсвующей JSP.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/CreateCarAd.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/SignUp.jsp");
            dispatcher.forward(req, resp);
        }
    }

    /**
     * Создание объявления. Загрузка изображений на сервер производится с помощью apache.commons.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int factoryID = (Integer) getServletContext().getAttribute("factoryID");
        DAOFactory daoFactory = DAOFactory.getDAOFactory(factoryID);
        HttpSession session = req.getSession();
        User creator = (User) session.getAttribute("user");
        Map<String, String> parameters = new HashMap<>();

        if (daoFactory != null) {
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            if (isMultipart) {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(1024 * 1024 * 10);

                ServletContext servletContext = this.getServletConfig().getServletContext();
                File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                factory.setRepository(repository);

                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setSizeMax(1024 * 1024 * 15);
                List<String> images = new ArrayList<>();
                long folder = creator.getId() % 26;
                try {
                    List<FileItem> items = upload.parseRequest(req);
                    for (FileItem item : items) {
                        if (item.isFormField()) {
                            String name = item.getFieldName();
                            String value = new String(item.getString()
                                    .getBytes("iso-8859-1"), "utf-8");
                            parameters.put(name, value);
                        } else {
                            if (!item.getName().isEmpty()) {
                                String mainPath = getServletContext().getRealPath("")
                                        + "images" + File.separator + folder + File.separator + item.getName();
                                images.add(folder + File.separator + item.getName());
                                File mainFile = new File(mainPath);
                                if (!mainFile.getParentFile().exists()) {
                                    mainFile.getParentFile().mkdir();
                                }
                                mainFile.createNewFile();

                                String smallPath = getServletContext()
                                        .getRealPath("") + "images" + File.separator
                                        + "small" + File.separator + folder + File.separator + item.getName();
                                File smallFile = new File(smallPath);
                                if (!smallFile.getParentFile().exists()) {
                                    smallFile.getParentFile().mkdir();
                                }
                                smallFile.createNewFile();
                                BufferedImage bufferedImage = ImageIO.read(item.getInputStream());
                                ImageReSizer reSizer = new ImageReSizer();
                                BufferedImage mainBufferedImage = reSizer
                                        .resize(800, 800, bufferedImage);
                                BufferedImage smallBufferedImage = reSizer
                                        .resize(200, 150, bufferedImage);
                                ImageIO.write(mainBufferedImage, "JPEG", mainFile);
                                ImageIO.write(smallBufferedImage, "JPEG", smallFile);
                            }
                        }
                    }
                } catch (FileUploadException e) {
                    LOGGER.error(e.getMessage(), e);
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    return;
                }
                createCarAd(creator, parameters, images, daoFactory);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Successad.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }

    /**
     * Сохранение объявления.
     * @param creator создатель.
     * @param parameters ассоциативный массив с именами и содержанием полей формы.
     * @param images список загруженных картинок.
     * @param daoFactory фабрика.
     */
    private void createCarAd(User creator, Map<String, String> parameters, List<String> images, DAOFactory daoFactory) {
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
        CityDAO cityDAO = daoFactory.getCityDAO();
        City city = cityDAO.getByID(cityId);
        ModelDAO modelDAO = daoFactory.getModelDAO();
        Model model = modelDAO.getByID(modelId);

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
        CarAdDAO carAdDAO = daoFactory.getCarAdDAO();
        carAdDAO.create(carAd);
    }
}
