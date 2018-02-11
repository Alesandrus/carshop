package ru.treejoy.model.parts;

import java.util.Locale;

/**
 * Перечисление типов кузова.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public enum Body {
    /**
     * Седан.
     */
    SEDAN,

    /**
     * Хэтчбэк.
     */
    HATCHBACK,

    /**
     * Микроавтобус.
     */
    WAGON,

    /**
     * Внедорожник.
     */
    SUV,

    /**
     * Кабриолет.
     */
    CABRIOLET,

    /**
     * Купе.
     */
    COUPE,

    /**
     * Лимузин.
     */
    LIMO,

    /**
     * Минивэн.
     */
    MINIVAN,

    /**
     * Пикап.
     */
    PICKUP,

    /**
     * Фургон.
     */
    VAN,

    /**
     * Миниавтобус.
     */
    MINIBUS;

    /**
     * Получение массива строк всех типов кузова(все буквы строчные).
     *
     * @return массив строк.
     */
    public static String[] toArrayString() {
        Body[] bodies = Body.values();
        String[] bodyList = new String[bodies.length];
        for (int i = 0; i < bodies.length; i++) {
            bodyList[i] = bodies[i].toString().toLowerCase(Locale.ENGLISH);
        }
        return bodyList;
    }
}
