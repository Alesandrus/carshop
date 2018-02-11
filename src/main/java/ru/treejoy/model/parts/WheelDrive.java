package ru.treejoy.model.parts;

import java.util.Locale;

/**
 * Перечисление типов приводов.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public enum WheelDrive {
    /**
     * Передний.
     */
    FRONT,

    /**
     * Задний.
     */
    REAR,

    /**
     * Полный.
     */
    AWD;

    /**
     * Получение массива строк всех типов приводов(все буквы строчные).
     *
     * @return массив строк.
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
