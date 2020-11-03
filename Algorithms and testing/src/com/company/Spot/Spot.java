package com.company.Spot;

import java.util.Random;

public class Spot {

    static int randomBetween(int start, int end) {
        Random generator = new Random();

        int result = generator.nextInt(end - start + 1);
        return result + start;
    }

    int[] spot(int[] tab, int target) {
        int[] results = new int[2];

        for (int i = 0; i < tab.length; ++i) {
            for (int j = 0; j < tab.length; ++j) {

                if(i == j){
                    continue;
                }

                if (tab[i] * tab[j] == target) {
                    results[0] = tab[i];
                    results[1] = tab[j];
                    return results;
                }
            }
        }
        throw new NoSolutionException("No such pair of numbers for " + target);
    }

    public Object run() {
        int[] tab = new int[10000];
        int target = 100;

        for (int i = 0; i < tab.length; ++i) {
            tab[i] = randomBetween(-1000, 1000);
        }


        int[] results = new int[2];
        try {
            results = spot(tab, target);
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception thrown." + exception + " => no solution.");
        }


        System.out.println("Looking for: " + target);
        System.out.println("Points : " + results[0] + " " + results[1]);

        return null;
    }
}
