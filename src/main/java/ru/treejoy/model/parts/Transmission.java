package ru.treejoy.model.parts;

import java.util.Locale;

/**
 * Enum for transmission types.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public enum Transmission {
    /**
     * Manual.
     */
    MANUAL,

    /**
     * Automatic.
     */
    AUTOMATIC,

    /**
     * Robot.
     */
    ROBOT,

    /**
     * Variator.
     */
    VARIATOR;

    /**
     * Gets array of string in lower case for all transmission types.
     *
     * @return array of string.
     */
    public static String[] toArrayString() {
        Transmission[] transmissions = Transmission.values();
        String[] transmissionList = new String[transmissions.length];
        for (int i = 0; i < transmissions.length; i++) {
            transmissionList[i] = transmissions[i].toString().toLowerCase(Locale.ENGLISH);
        }
        return transmissionList;
    }
}
