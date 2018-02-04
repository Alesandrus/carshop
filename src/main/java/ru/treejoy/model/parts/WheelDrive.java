package ru.treejoy.model.parts;

import java.util.Locale;

public enum WheelDrive {
    FRONT,
    REAR,
    AWD;

    public static String[] toArrayString() {
        WheelDrive[] wheelDrives = WheelDrive.values();
        String[] wheelDriveList = new String[wheelDrives.length];
        for (int i = 0; i < wheelDrives.length; i++) {
            wheelDriveList[i] = wheelDrives[i].toString().toLowerCase(Locale.ENGLISH);
        }
        return wheelDriveList;
    }
}
