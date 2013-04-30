package org.isma.slick2d;

import java.util.Random;

public enum Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public static Direction rand() {
        return values()[new Random().nextInt(values().length)];
    }
}
