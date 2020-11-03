package com.company.Spot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.company.Spot.Spot.randomBetween;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    @DisplayName("Testing random and spot functions.")
    public void testingRandomAndSpotFunctions() {
        Spot spot = new Spot();
        assertEquals(1, randomBetween(1, 1));
        assertEquals(0, randomBetween(0, 0));
        assertEquals(-10000, randomBetween(-10000, -10000));


        assertArrayEquals(new int[]{1, 1}, spot.spot(new int[]{1, 1, 1, 1}, 1));
    }

    @Test
    @DisplayName("Testing throwing exception.")
    public void testingThrowingException() {
        Spot spot = new Spot();
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> spot.spot(new int[]{1, 1, 1, 1}, 0));
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingSpotRuntime() {
        Spot spot = new Spot();
        int[] tab = new int[1000];
        int target = 100;

        for (int i = 0; i < tab.length; ++i) {
            tab[i] = randomBetween(-1000, 1000);
        }

        assertTimeout(Duration.ofMillis(500), () -> spot.spot(tab, target));
    }

    @Test
    @DisplayName("Testing run() function work.")
    public void testingMainFunction() {
        Spot spot = new Spot();
        assertNull(spot.run());
    }
}
