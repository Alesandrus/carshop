package ru.treejoy.model.parts;

import java.util.Locale;

public enum Transmission {
    MANUAL,
    AUTOMATIC,
    ROBOT,
    VARIATOR;

    public static String[] toArrayString() {
        Transmission[] transmissions = Transmission.values();
        String[] transmissionList = new String[transmissions.length];
        for (int i = 0; i < transmissions.length; i++) {
            transmissionList[i] = transmissions[i].toString().toLowerCase(Locale.ENGLISH);
        }
        return transmissionList;
    }
}
