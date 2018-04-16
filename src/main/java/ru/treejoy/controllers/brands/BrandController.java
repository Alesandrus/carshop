package ru.treejoy.controllers.brands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.treejoy.dao.services.BrandService;
import ru.treejoy.model.brands.Brand;

import java.util.List;

/**
 * Controller for getting all brands.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 12.04.2018
 */
@RequestMapping("/getbrands")
@Controller
public class BrandController {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Brandservice.
     */
    @Autowired
    private BrandService brandService;

    /**
     * Post JSON brand list.
     *
     * @return list of brands.
     */
    @PostMapping(produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Brand> getBrands() {
        return brandService.getAll();
    }
}
