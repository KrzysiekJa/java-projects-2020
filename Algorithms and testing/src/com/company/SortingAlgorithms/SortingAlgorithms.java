package com.company.SortingAlgorithms;

import java.util.Random;

public class SortingAlgorithms {
    public void run() {
        long[] randomTab = new long[100000];
        long[] optimalTab = new long[100000];
        long[] pessimisticTab = new long[100000];
        Random generator = new Random();

        for (int i = 0; i < randomTab.length - 1; ++i) {
            randomTab[i] = generator.nextInt();
            optimalTab[i] = i;
            pessimisticTab[i] = pessimisticTab.length - i;
        }

        System.out.println("Random/Optimal/Pessimistic");
        I_SortingAlgorithm algorithm = new InsertionSort();

        long[] testingTab = randomTab.clone();
        long tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSecondsRandom = tDelta / 1000.0;

        testingTab = optimalTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        double elapsedSecondsOptimal = tDelta / 1000.0;

        testingTab = pessimisticTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        double elapsedSecondsPessimistic = tDelta / 1000.0;

        System.out.println("Insertion sort:");
        System.out.println(elapsedSecondsRandom + " " + elapsedSecondsOptimal + " " + elapsedSecondsPessimistic);


        algorithm = new BubbleSort();
        testingTab = randomTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsRandom = tDelta / 1000.0;

        testingTab = optimalTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsOptimal = tDelta / 1000.0;

        testingTab = pessimisticTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsPessimistic = tDelta / 1000.0;

        System.out.println("Bubble sort:");
        System.out.println(elapsedSecondsRandom + " " + elapsedSecondsOptimal + " " + elapsedSecondsPessimistic);


        algorithm = new ShellSort();
        testingTab = randomTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsRandom = tDelta / 1000.0;

        testingTab = optimalTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsOptimal = tDelta / 1000.0;

        testingTab = pessimisticTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsPessimistic = tDelta / 1000.0;

        System.out.println("Shell sort:");
        System.out.println(elapsedSecondsRandom + " " + elapsedSecondsOptimal + " " + elapsedSecondsPessimistic);


        algorithm = new CocktailSort();
        testingTab = randomTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsRandom = tDelta / 1000.0;

        testingTab = optimalTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsOptimal = tDelta / 1000.0;

        testingTab = pessimisticTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsPessimistic = tDelta / 1000.0;

        System.out.println("Cocktail sort:");
        System.out.println(elapsedSecondsRandom + " " + elapsedSecondsOptimal + " " + elapsedSecondsPessimistic);


        algorithm = new SelectionSort();
        testingTab = randomTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsRandom = tDelta / 1000.0;

        testingTab = optimalTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsOptimal = tDelta / 1000.0;

        testingTab = pessimisticTab.clone();
        tStart = System.currentTimeMillis();
        algorithm.sort(testingTab);
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSecondsPessimistic = tDelta / 1000.0;

        System.out.println("Selection sort:");
        System.out.println(elapsedSecondsRandom + " " + elapsedSecondsOptimal + " " + elapsedSecondsPessimistic);

    }
}
