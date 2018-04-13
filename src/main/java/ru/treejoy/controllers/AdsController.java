package ru.treejoy.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.treejoy.dao.services.CarAdService;
import ru.treejoy.model.ad.CarAd;

import java.util.List;

/**
 * Контроллер, отвечающий за получение всех объявления.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@RequestMapping("/getallads")
@Controller
public class AdsController {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Autowired
    private CarAdService carAdService;

    /**
     * Отправка JSON со списком всех объявлений.
     */
    @GetMapping(produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<CarAd> getAllAds(@RequestParam(value = "brand", required = false) String brand,
                                 @RequestParam(value = "model", required = false) String model,
                                 @RequestParam(value = "foto", required = false) String foto,
                                 @RequestParam(value = "today", required = false) String today) {
        long brandID = 0;
        if (brand != null && !brand.isEmpty()) {
            brandID = Long.parseLong(brand);
        }
        long modelID = 0;
        if (model != null && !model.isEmpty()) {
            modelID = Long.parseLong(model);
        }
        boolean onlyWithFoto = false;
        if (foto != null && foto.equals("on")) {
            onlyWithFoto = true;
        }
        boolean isToday = false;
        if (today != null && today.equals("on")) {
            isToday = true;
        }
        return carAdService.getAllFromFilter(brandID, modelID, onlyWithFoto, isToday);
    }
}
