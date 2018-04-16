package ru.treejoy.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.treejoy.dao.services.UserService;
import ru.treejoy.exceptions.CreateEmailException;
import ru.treejoy.exceptions.CreateLoginException;
import ru.treejoy.model.User;

import javax.validation.Valid;

/**
 * Controller for user registration.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.04.2018
 */
@RequestMapping("/signup")
@Controller
public class SignUpController {
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
     * Creates user and redirect to post request.
     *
     * @param model uiModel.
     * @return part of url.
     */
    @GetMapping
    public String goToSignUp(Model model) {
        model.addAttribute("user", new User());
        return "SignUp";
    }

    /**
     * User registration.
     *
     * @param user          for registration.
     * @param bindingResult binding results.
     * @return part of url.
     */
    @PostMapping
    public String signUp(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "SignUp";
        }
        try {
            userService.create(user);
        } catch (CreateLoginException e) {
            return "Failcreatelogin";
        } catch (CreateEmailException e) {
            return "Failcreateemail";
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "Successcreate";
    }
}
