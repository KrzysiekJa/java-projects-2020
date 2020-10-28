package com.company.FindThree;

import java.util.Random;

public class FindThree {

    int[] maxTriplet(int[] table) {
        if(table.length < 3){
            throw new EmptyTableException("Table has less elements than 3.");
        }

        int max = 0;
        int length = table.length;
        int[] result = new int[3];


        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; ++j) {
                for (int k = j + 1; k < length; ++k) {

                    if (table[i] + table[j] + table[k] > max) {
                        max = table[i] + table[j] + table[k];
                        result[0] = table[i];
                        result[1] = table[j];
                        result[2] = table[k];
                    }
                }
            }
        }

        return result;
    }

    public void run() {
        int[] tab = new int[1000];
        Random generator = new Random();

        for (int i = 0; i < tab.length - 1; ++i) {
            tab[i] = generator.nextInt();
        }


        int[] results = new int[3];
        try {
            results = maxTriplet(tab);
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception thrown." + exception + " => no solution.");
        }


        System.out.println("Looking for maximum value of sum of integers.");
        System.out.println("The best trio :" + results[0] + " " + results[1] + " " + results[2]);
    }
}
