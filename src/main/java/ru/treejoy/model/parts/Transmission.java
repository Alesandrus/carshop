package ru.treejoy.model.parts;

import java.util.Locale;

/**
 * Перечисление типов КПП.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public enum Transmission {
    /**
     * Ручная.
     */
    MANUAL,

    /**
     * Автоматическая.
     */
    AUTOMATIC,

    /**
     * Роботизированная.
     */
    ROBOT,

    /**
     * Вариатор.
     */
    VARIATOR;

    /**
     * Получение массива строк всех типов КПП(все буквы строчные).
     *
     * @return массив строк.
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
