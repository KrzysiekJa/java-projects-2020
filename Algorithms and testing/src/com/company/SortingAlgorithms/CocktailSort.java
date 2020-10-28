package com.company.SortingAlgorithms;

public class CocktailSort implements I_SortingAlgorithm{

    @Override
    public void sort(long[] table) {
        boolean swapped = true;
        int start = 0;
        int end = table.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (table[i] > table[i + 1]) {
                    long tmp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

            swapped = false;
            end -= 1;

            for (int i = end - 1; i >= start; --i) {
                if (table[i] > table[i + 1]) {
                    long tmp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = tmp;
                    swapped = true;
                }
            }

            start += 1;
        }
    }
}
