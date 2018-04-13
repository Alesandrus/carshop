package ru.treejoy.controllers.geo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.treejoy.dao.services.CountryService;
import ru.treejoy.model.geo.Country;

import java.util.List;

/**
 * Контроллер, отвечающий за получение всех стран.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@RequestMapping("/getcountries")
@Controller
public class CountryController {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Autowired
    private CountryService countryService;

    /**
     * Отправка JSON со списком стран.
     */
    @PostMapping(produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Country> getAllCountries() {
        return countryService.getAll();
    }
}
