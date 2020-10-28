package com.company.Substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    @DisplayName("Testing substring function.")
    void testingSubstringFunction(){
        Substring substring = new Substring();

        assertEquals(3, substring.substring("abcd", "cdabcdab"));
        assertEquals(-1, substring.substring("abcd", "xyz"));
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> substring.substring("", "xyz"));
    }
}
