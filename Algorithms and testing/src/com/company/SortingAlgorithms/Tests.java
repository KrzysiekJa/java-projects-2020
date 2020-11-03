package com.company.SortingAlgorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    private final long[] rawTab = {6, 12, 201, 8, 55, 321, 7, 37, 1001, 1};
    private final long[] sortedTab = rawTab.clone();
    Random random = new Random();
    private final long[] timeTab = random.longs(10000, 0, 10000).toArray();
    private I_SortingAlgorithm algorithm;


    @Test
    @DisplayName("Methods should return sorted arrays.")
    public void InsertionSortShouldReturnSortedArray() {
        algorithm = new InsertionSort();
        long[] testingTab = rawTab.clone();
        Arrays.sort(sortedTab);
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingInsertionSortRuntime() {
        algorithm = new InsertionSort();
        assertTimeout(Duration.ofMillis(1000), () -> algorithm.sort(timeTab));
    }


    @Test
    @DisplayName("Methods should return sorted arrays.")
    public void bubbleSortShouldReturnSortedArray() {
        algorithm = new BubbleSort();
        long[] testingTab = rawTab.clone();
        Arrays.sort(sortedTab);
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingBubbleSortRuntime() {
        algorithm = new BubbleSort();
        assertTimeout(Duration.ofMillis(1000), () -> algorithm.sort(timeTab));
    }


    @Test
    @DisplayName("Methods should return sorted arrays.")
    public void shellSortShouldReturnSortedArray() {
        algorithm = new ShellSort();
        long[] testingTab = rawTab.clone();
        Arrays.sort(sortedTab);
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingShellSortRuntime() {
        algorithm = new ShellSort();
        assertTimeout(Duration.ofMillis(1000), () -> algorithm.sort(timeTab));
    }


    @Test
    @DisplayName("Methods should return sorted arrays.")
    public void cocktailSortShouldReturnSortedArray() {
        algorithm = new CocktailSort();
        long[] testingTab = rawTab.clone();
        Arrays.sort(sortedTab);
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingCocktailSortRuntime() {
        algorithm = new CocktailSort();
        assertTimeout(Duration.ofMillis(1000), () -> algorithm.sort(timeTab));
    }


    @Test
    @DisplayName("Methods should return sorted arrays.")
    public void selectionSortShouldReturnSortedArray() {
        algorithm = new SelectionSort();
        long[] testingTab = rawTab.clone();
        Arrays.sort(sortedTab);
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingSelectionSortRuntime() {
        algorithm = new SelectionSort();
        assertTimeout(Duration.ofMillis(1000), () -> algorithm.sort(timeTab));
    }


    @Test
    @DisplayName("Methods should return sorted arrays.")
    public void quickSortShouldReturnSortedArray() {
        algorithm = new QuickSort();
        long[] testingTab = rawTab.clone();
        Arrays.sort(sortedTab);
        algorithm.sort(testingTab);
        assertArrayEquals(sortedTab, testingTab);
    }

    @Test
    @DisplayName("Testing timeout of function.")
    public void testingQuickSortRuntime() {
        algorithm = new QuickSort();
        assertTimeout(Duration.ofMillis(1000), () -> algorithm.sort(timeTab));
    }



    @Test
    @DisplayName("Testing run() function work.")
    public void testingMainFunction() {
        SortingAlgorithms algorithm = new SortingAlgorithms();
        assertNull(algorithm.run());
    }
}
