package ru.treejoy.dao;

import ru.treejoy.model.geo.Country;

import java.util.List;

/**
 * Абстрактный класс DAO для страны.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 31.01.2018
 */
public abstract class CountryDAO implements EntityDAO<Country> {
    /**
     * Создание сущности страны.
     *
     * @param entity страна.
     */
    @Override
    public abstract void create(Country entity);

    /**
     * Получение стран.
     *
     * @return список стран.
     */
    @Override
    public abstract List<Country> getAll();

    /**
     * Получение страны по ID.
     *
     * @param id страны.
     * @return страну.
     */
    @Override
    public abstract Country getByID(long id);

    /**
     * Обновить страну.
     *
     * @param entity страна.
     */
    @Override
    public abstract void update(Country entity);

    /**
     * Удалить страну.
     *
     * @param entity страна.
     */
    @Override
    public abstract void delete(Country entity);
}