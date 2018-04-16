package ru.treejoy.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.treejoy.dao.services.CarAdService;
import ru.treejoy.model.ad.CarAd;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Controller for getting information about ad.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.04.2018
 */
@RequestMapping("/getad")
@Controller
public class AddInfoController {
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
     * Get information about ad.
     *
     * @param id      of car ad.
     * @param request http request.
     * @return part of url.
     */
    @GetMapping
    public String getAdInfo(@RequestParam(value = "id") String id, HttpServletRequest request) {
        CarAd ad = carAdService.getByID(Long.parseLong(id));
        request.setAttribute("ad", ad);
        String pattern = "dd.MM.yyyy H:m";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String created = dateFormat.format(ad.getCreated());
        request.setAttribute("created", created);
        return "AdInfo";
    }
}
