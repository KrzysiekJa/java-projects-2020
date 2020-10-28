package com.company.Spiral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> spiral.spriralFunction(new int[][]{}));
    }
}
