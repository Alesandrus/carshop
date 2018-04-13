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
 * Контроллер, отвечающий за получение информации об объявлении.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@RequestMapping("/getad")
@Controller
public class AddInfoController {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Autowired
    private CarAdService carAdService;

    /**
     * Получение информации об объявлении и ее сохранение в запросе.
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
