package ru.treejoy.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.treejoy.dao.services.UserService;
import ru.treejoy.model.User;

import javax.servlet.http.HttpSession;

/**
 * Контроллер, отвечающий за аутентификацию пользователя.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Controller
@RequestMapping("/login")
public class LogInController {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Autowired
    private UserService userService;

    /**
     * Аутентификация пользователя.
     */
    @PostMapping
    public String login(@RequestParam("login") String login, @RequestParam("password") String password,
                        HttpSession session) {
        User user = userService.getByLoginAndPassword(login, password);
        if (user == null) {
            return "Notfound";
        }
        session.setAttribute("user", user);
        return "redirect:/index.jsp";
    }
}
