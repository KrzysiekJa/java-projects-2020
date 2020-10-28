package com.company.SortingAlgorithms;

public class BubbleSort implements I_SortingAlgorithm {

    @Override
    public void sort(long[] table) {
        int length = table.length;

        for (int i = 0; i < length - 1; ++i) {
            for (int j = 0; j < length - i - 1; ++j) {
                if (table[j] > table[j + 1]) {
                    long tmp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = tmp;
                }
            }
        }
    }
}