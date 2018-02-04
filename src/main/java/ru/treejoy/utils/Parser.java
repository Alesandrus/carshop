package ru.treejoy.utils;

import ru.treejoy.model.brands.Brand;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Парсер Item в JSON.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 24.01.2018
 */
public class Parser {
    /**
     * Парсинг item в JSON-формат.
     *
     * @param brand задание для парсинга.
     * @return строку в JSON-формате.
     */
    public static String brandToJson(Brand brand) {
        long id = brand.getId();
        String name = brand.getName();
        return "{\"id\": " + id + ", \"name\": \"" + name + "}";
    }
}
