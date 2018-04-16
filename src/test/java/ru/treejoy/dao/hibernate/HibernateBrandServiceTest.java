package ru.treejoy.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.treejoy.dao.services.BrandService;
import ru.treejoy.dao.services.ModelService;
import ru.treejoy.model.brands.Brand;
import ru.treejoy.model.brands.Model;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test HibernateBrandService.
 */

public class HibernateBrandServiceTest {

    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * BrandService.
     */
    @Autowired
    private static BrandService brandService;

    /**
     * ModelService.
     */
    @Autowired
    private static ModelService modelService;

    /**
     * Тест создания бренда.
     */
    @org.junit.Test
    public void create() {
        Brand brand = new Brand();
        brand.setName("Ford");
        brandService.create(brand);
        assertThat(brand, is(brandService.getByID(brand.getId())));
        brandService.delete(brand);
    }

    /**
     * Тест получения всех брендов.
     */
    @org.junit.Test
    public void getAll() {
        Brand ford = new Brand();
        ford.setName("Ford");
        brandService.create(ford);
        Brand bmw = new Brand();
        bmw.setName("BMW");
        brandService.create(bmw);
        List<Brand> brands = Arrays.asList(ford, bmw);
        assertThat(brands, is(brandService.getAll()));
        brandService.delete(ford);
        brandService.delete(bmw);
    }

    /**
     * Тест обновления бренда.
     */
    @org.junit.Test
    public void update() {
        Brand brand = new Brand();
        brand.setName("Ford");
        brandService.create(brand);
        brand.setName("BMW");
        brandService.update(brand);
        assertThat("BMW", is(brandService.getByID(brand.getId()).getName()));
        brandService.delete(brand);
    }

    /**
     * Тест удаления бренда.
     */
    @org.junit.Test
    public void delete() {
        Brand ford = new Brand();
        ford.setName("Ford");
        brandService.create(ford);
        assertTrue(brandService.getAll().contains(ford));
        brandService.delete(ford);
        assertFalse(brandService.getAll().contains(ford));
    }

    /**
     * Тест получения всех моделей одного бренда.
     */
    @org.junit.Test
    public void getModels() {
        Brand ford = new Brand();
        ford.setName("Ford");
        brandService.create(ford);

        Model focus = new Model();
        focus.setName("Focus");
        focus.setBrand(ford);
        modelService.create(focus);

        Model mondeo = new Model();
        mondeo.setName("Mondeo");
        mondeo.setBrand(ford);
        modelService.create(mondeo);

        List<Model> models = Arrays.asList(focus, mondeo);
        assertThat(models, is(modelService.findAllByBrandID(ford.getId())));
        modelService.delete(mondeo);
        modelService.delete(focus);
        brandService.delete(ford);
    }
}
