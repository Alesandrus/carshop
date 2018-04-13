package ru.treejoy.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.treejoy.dao.services.UserService;

import javax.servlet.http.HttpSession;

/**
 * Контроллер, отвечающий за выход из сессии.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 06.12.2017
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Autowired
    private UserService userService;

    /**
     * Выход из сессии.
     */
    @GetMapping
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/index.jsp";
    }
}
