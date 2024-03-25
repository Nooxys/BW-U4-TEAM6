package TEAM6.enums;

import java.util.Random;

public enum SubType {
    WEEKLY, MONTHLY;

    private static final Random random = new Random();

    public static SubType randomSubType() {
        SubType[] subTypes = values();
        return subTypes[random.nextInt(subTypes.length)];
    }
}