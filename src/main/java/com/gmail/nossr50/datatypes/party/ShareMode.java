package com.gmail.nossr50.datatypes.party;

public enum ShareMode {
    NONE,
    EQUAL,
    RANDOM;

    public static ShareMode getShareMode(String string) {
        try {
            return valueOf(string);
        } catch (IllegalArgumentException ex) {
            if (string.equalsIgnoreCase("even")) {
                return EQUAL;
            } else {
                return NONE;
            }
        }
    }
}
