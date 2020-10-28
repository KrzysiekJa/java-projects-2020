package com.company.FindThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Tests {

    @Test
    @DisplayName("Testing FindThree class' functions.")
    public void testingFindThree(){
        FindThree finder = new FindThree();

        assertArrayEquals(new int[]{2,2,2}, finder.maxTriplet(new int[]{2,2,0,2,1,1,1}));
        assertArrayEquals(new int[]{-5,10,1}, finder.maxTriplet(new int[]{ -5, -7, 10, 1 }));

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> finder.maxTriplet(new int[]{1, 1}));
    }
}
