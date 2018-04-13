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
 * Контроллер, отвечающий за получение всех моделей определенного бренда.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@RequestMapping("/getmodels")
@Controller
public class ModelController {

    /**
     * Логгер.
     */

    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Autowired
    private ModelService modelService;

    /**
     * Отправка JSON со списком моделей.
     */
    @PostMapping(produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Model> getModelsByBrandId(@RequestParam("brand") String brand) {
        return modelService.findAllByBrandID(Long.parseLong(brand));
    }
}

