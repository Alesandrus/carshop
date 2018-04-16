package ru.treejoy.model.parts;

import java.util.Locale;

/**
 * Enum for body types.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public enum Body {
    /**
     * Sedan.
     */
    SEDAN,

    /**
     * Hatchback.
     */
    HATCHBACK,

    /**
     * Wagon.
     */
    WAGON,

    /**
     * Suv.
     */
    SUV,

    /**
     * Cabriolet.
     */
    CABRIOLET,

    /**
     * Coupe.
     */
    COUPE,

    /**
     * Лимузин.
     */
    LIMO,

    /**
     * Minivan.
     */
    MINIVAN,

    /**
     * Pickup.
     */
    PICKUP,

    /**
     * Van.
     */
    VAN,

    /**
     * Minibus.
     */
    MINIBUS;

    /**
     * Gets array of string in lower case for all body types.
     *
     * @return array of string.
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
