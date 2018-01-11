package app.utils;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    STOP(0), // Exit console
    AUTH(-1), // regist or login menu
    MENU(1), // main menu
    DATA(2); // data menu

    private final int abbreviation;

    // Reverse-lookup map for getting a day from an abbreviation
    private static final Map<Integer, Status> lookup = new HashMap<>();

    static {
        for (Status d : Status.values()) {
            lookup.put(d.getAbbreviation(), d);
        }
    }

    Status(int abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getAbbreviation() {
        return abbreviation;
    }

    public static Status get(int abbreviation) {
        return lookup.get(abbreviation);
    }
}
