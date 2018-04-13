package ru.treejoy.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.treejoy.dao.services.CarAdService;
import ru.treejoy.model.User;
import ru.treejoy.model.ad.CarAd;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер, отвечающий за получение всех объявлений залогинившегося пользователя.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Autowired
    private CarAdService carAdService;

    /**
     * Проверяет залогинин ли пользователь.
     */
    @GetMapping
    public String UserIsValidate(HttpSession session) {
        /*User user = (User) session.getAttribute("user");
        if (user != null) {
            return "Account";
        } else {
            return "redirect:/index.jsp";
        }*/
        return  "Account";
    }

    /**
     * Отправка JSON со списком объявлений пользователя.
     */
    @PostMapping(produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<CarAd> getUserCarAds(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<CarAd> carAds = new ArrayList<>();
        if (user != null) {
            long id = user.getId();
            carAds = carAdService.getAllByUserId(id);
        }
        return carAds;
    }
}
