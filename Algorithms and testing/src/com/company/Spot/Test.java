package com.company.Spot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    @DisplayName("Testing random and spot functions.")
    public void testingRandomAndSpotFunctions() {
        Spot spot = new Spot();
        assertEquals(1, spot.randomBetween(1, 1));
        assertEquals(0, spot.randomBetween(0, 0));
        assertEquals(-10000, spot.randomBetween(-10000, -10000));


        assertArrayEquals(new int[]{1, 1}, spot.spot(new int[]{1, 1, 1, 1}, 1));
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> spot.spot(new int[]{1, 1, 1, 1}, 0));
    }
}
