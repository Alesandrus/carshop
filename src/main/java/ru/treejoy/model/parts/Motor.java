package ru.treejoy.model.parts;

import java.util.Locale;

/**
 * Перечисление типов двигателей.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public enum Motor {
    /**
     * Бензин.
     */
    GASOLINE,

    /**
     * Дизель.
     */
    DIESEL,

    /**
     * Гибрид.
     */
    HYBRID,

    /**
     * Электрический.
     */
    ELECTRIC,

    /**
     * Газ.
     */
    GAS;

    /**
     * Получение массива строк всех типов двигателей(все буквы строчные).
     *
     * @return массив строк.
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
