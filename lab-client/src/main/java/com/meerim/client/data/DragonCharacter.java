package com.meerim.client.data;

public enum DragonCharacter {
    CUNNING,
    EVIL,
    GOOD,
    CHAOTIC_EVIL;


    /**
     * Returns comma separated list with the forms.
     * @return CUNNING, EVIL, GOOD, CHAOTIC_EVIL
     */
    public static String nameList() {
        StringBuilder nameList = new StringBuilder();
        for (DragonCharacter character: values()) {
            nameList.append(character.name()).append(", ");
        }
        return nameList.substring(0, nameList.length() - 2);
    }
    public static DragonCharacter valueOfOrNull(String token) {
        if (token == null) {
            return null;
        } else {
            return valueOf(token);
        }
    }
}

