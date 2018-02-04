package ru.treejoy.model.parts;

import java.util.Locale;

public enum  Motor {
    GASOLINE,
    DIESEL,
    HYBRID,
    ELECTRIC,
    GAS;

    public static String[] toArrayString() {
        Motor[] motors = Motor.values();
        String[] motorList = new String[motors.length];
        for (int i = 0; i < motors.length; i++) {
            motorList[i] = motors[i].toString().toLowerCase(Locale.ENGLISH);
        }
        return motorList;
    }
}
