package com.company.SortingAlgorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Tests {
    @Test
    @DisplayName("It should return sorted arrays.")
    public void shouldReturnSortedArray() {
        long[] rawTab = {6, 12, 201, 8, 55, 321, 7, 37, 1001, 1};
        I_SortingAlgorithm algorithm = new InsertionSort();
        long[] sortedTab = rawTab.clone();
        long[] testingTab = rawTab.clone();
        Arrays.sort(sortedTab);

        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);

        algorithm = new BubbleSort();
        testingTab = rawTab.clone();
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);

        algorithm = new ShellSort();
        testingTab = rawTab.clone();
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);

        algorithm = new CocktailSort();
        testingTab = rawTab.clone();
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);

        algorithm = new SelectionSort();
        testingTab = rawTab.clone();
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);
    }
}
