package ru.treejoy.controllers.brands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.treejoy.dao.services.ModelService;
import ru.treejoy.model.brands.Model;

import java.util.List;

/**
 * Controller for getting all brand's models.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 12.04.2018
 */
@RequestMapping("/getmodels")
@Controller
public class ModelController {

    /**
     * Logger.
     */

    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Model service.
     */
    @Autowired
    private ModelService modelService;

    /**
     * Post JSON brand's models list.
     *
     * @param brand id.
     * @return list of models.
     */
    @PostMapping(produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Model> getModelsByBrandId(@RequestParam("brand") String brand) {
        return modelService.findAllByBrandID(Long.parseLong(brand));
    }
}

