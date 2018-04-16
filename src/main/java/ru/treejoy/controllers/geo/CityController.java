package ru.treejoy.controllers.geo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.treejoy.dao.services.CityService;
import ru.treejoy.model.geo.City;

import java.util.List;

/**
 * Controller for getting country's cities.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 12.04.2018
 */
@RequestMapping("/getcities")
@Controller
public class CityController {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * CityService.
     */
    @Autowired
    private CityService cityService;

    /**
     * Post JSON cities list.
     *
     * @param country country Id.
     * @return list of cities.
     */
    @PostMapping(produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<City> getAllByCountryId(@RequestParam("country") String country) {
        return cityService.findAllByCountryId(Long.parseLong(country));
    }
}
