package ru.treejoy.dao.services;

import ru.treejoy.model.geo.Country;

import java.util.List;

/**
 * Абстрактный класс DAO для страны.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public interface CountryService extends EntityService<Country> {
    /**
     * Создание сущности страны.
     *
     * @param entity страна.
     */
    @Override
    void create(Country entity);

    /**
     * Получение стран.
     *
     * @return список стран.
     */
    @Override
    List<Country> getAll();

    /**
     * Получение страны по ID.
     *
     * @param id страны.
     * @return страну.
     */
    @Override
    Country getByID(long id);

    /**
     * Обновить страну.
     *
     * @param entity страна.
     */
    @Override
    void update(Country entity);

    /**
     * Удалить страну.
     *
     * @param entity страна.
     */
    @Override
    void delete(Country entity);
}