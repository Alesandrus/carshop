package ru.treejoy.model.parts;

import java.util.Locale;

/**
 * Enum for wheel drive types.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public enum WheelDrive {
    /**
     * Front.
     */
    FRONT,

    /**
     * Rear.
     */
    REAR,

    /**
     * AWD.
     */
    AWD;

    /**
     * Gets array of string in lower case for all wheel drive types.
     *
     * @return array of string.
     */
    public static String[] toArrayString() {
        WheelDrive[] wheelDrives = WheelDrive.values();
        String[] wheelDriveList = new String[wheelDrives.length];
        for (int i = 0; i < wheelDrives.length; i++) {
            wheelDriveList[i] = wheelDrives[i].toString().toLowerCase(Locale.ENGLISH);
        }
        return wheelDriveList;
    }
}
