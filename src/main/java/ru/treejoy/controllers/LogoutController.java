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
 * Controller for invalidate session.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 12.04.2018
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * UserService.
     */
    @Autowired
    private UserService userService;

    /**
     * Logout.
     *
     * @param session http session.
     * @return part of url.
     */
    @GetMapping
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/index.jsp";
    }
}
