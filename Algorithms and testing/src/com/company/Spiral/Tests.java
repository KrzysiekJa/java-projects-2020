package com.company.Spiral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    @DisplayName("Testing spiral function.")
    public void testingSpiralFunction() {
        Spiral spiral = new Spiral();
        int[][] tab = {
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[] results = {11, 16, 21, 22, 23, 24, 25, 20, 15, 14, 13, 12, 17, 18, 19};

        assertArrayEquals(results, spiral.spriralFunction(tab));
    }

    @Test
    @DisplayName("Testing throwing exception.")
    public void testingThrowingException() {
        Spiral spiral = new Spiral();
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> spiral.spriralFunction(new int[][]{}));
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingSpiralFunctionRuntime() {
        Spiral spiral = new Spiral();
        int[][] tab = {
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        assertTimeout(Duration.ofMillis(500), () -> spiral.spriralFunction(tab));
    }

    @Test
    @DisplayName("Testing run() function work.")
    public void testingMainFunction() {
        Spiral spiral = new Spiral();
        assertNull(spiral.run());
    }
}
