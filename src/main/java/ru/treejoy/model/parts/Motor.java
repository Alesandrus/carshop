package ru.treejoy.model.parts;

import java.util.Locale;

/**
 * Enum for motor types.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public enum Motor {
    /**
     * Gasoline.
     */
    GASOLINE,

    /**
     * Diesel.
     */
    DIESEL,

    /**
     * Hybrid.
     */
    HYBRID,

    /**
     * Electric.
     */
    ELECTRIC,

    /**
     * Gas.
     */
    GAS;

    /**
     * Gets array of string in lower case for all motor types.
     *
     * @return array of string.
     */
    public static String[] toArrayString() {
        Motor[] motors = Motor.values();
        String[] motorList = new String[motors.length];
        for (int i = 0; i < motors.length; i++) {
            motorList[i] = motors[i].toString().toLowerCase(Locale.ENGLISH);
        }
        return motorList;
    }
}
