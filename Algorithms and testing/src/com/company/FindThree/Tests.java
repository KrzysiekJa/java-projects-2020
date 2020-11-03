package com.company.FindThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    @DisplayName("Testing FindThree class' functions.")
    public void testingFindThree() {
        FindThree finder = new FindThree();

        assertArrayEquals(new int[]{2, 2, 2}, finder.maxTriplet(new int[]{2, 2, 0, 2, 1, 1, 1}));
        assertArrayEquals(new int[]{-5, 10, 1}, finder.maxTriplet(new int[]{-5, -7, 10, 1}));
    }

    @Test
    @DisplayName("Testing throwing exception.")
    public void testingThrowingException() {
        FindThree finder = new FindThree();
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> finder.maxTriplet(new int[]{1, 1}));
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingMaxTripletRuntime() {
        FindThree finder = new FindThree();
        int[] tab = new int[1000];
        Random generator = new Random();

        for (int i = 0; i < tab.length - 1; ++i) {
            tab[i] = generator.nextInt();
        }

        assertTimeout(Duration.ofMillis(1000), () -> finder.maxTriplet(tab));
    }

    @Test
    @DisplayName("Testing run() function work.")
    public void testingMainFunction() {
        FindThree finder = new FindThree();
        assertNull(finder.run());
    }
}
