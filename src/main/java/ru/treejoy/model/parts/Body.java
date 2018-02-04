package ru.treejoy.model.parts;

import java.util.Locale;

public enum Body {
    SEDAN,
    HATCHBACK,
    WAGON,
    SUV,
    CABRIOLET,
    COUPE,
    LIMO,
    MINIVAN,
    PICKUP,
    VAN,
    MINIBUS;

    public static String[] toArrayString() {
        Body[] bodies = Body.values();
        String[] bodyList = new String[bodies.length];
        for (int i = 0; i < bodies.length; i++) {
            bodyList[i] = bodies[i].toString().toLowerCase(Locale.ENGLISH);
        }
        return bodyList;
    }
}
