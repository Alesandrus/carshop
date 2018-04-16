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
 * Controller for getting countries.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.04.2018
 */
@RequestMapping("/getcountries")
@Controller
public class CountryController {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * CountryService.
     */
    @Autowired
    private CountryService countryService;

    /**
     * Post JSON countries list..
     *
     * @return list of countries.
     */
    @PostMapping(produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Country> getAllCountries() {
        return countryService.getAll();
    }
}
