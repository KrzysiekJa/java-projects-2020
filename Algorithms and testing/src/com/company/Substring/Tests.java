package com.company.Substring;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {


    @DisplayName("Testing substring function.")
    void testingSubstringFunction() {
        Substring substring = new Substring();

        assertEquals(3, substring.substring("abcd", "cdabcdab"));
        assertEquals(-1, substring.substring("abcd", "xyz"));
    }

    @Test
    @DisplayName("Testing throwing exception.")
    public void testingThrowingException() {
        Substring substring = new Substring();
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> substring.substring("", "xyz"));
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingSubstringRuntime() {
        Substring substringAlgo = new Substring();
        String string = "abcd", substring = "cdabcdab";

        assertTimeout(Duration.ofMillis(500), () -> substringAlgo.substring(string, substring));
    }

    @Test
    @DisplayName("Testing run() function work.")
    public void testingMainFunction() {
        Substring substring = new Substring();
        assertNull(substring.run());
    }
}
