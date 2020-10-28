package com.company.SortingAlgorithms;

public class SelectionSort implements I_SortingAlgorithm {

    @Override
    public void sort(long[] table) {
        int length = table.length;

        for (int i = 0; i < length - 1; ++i) {

            int min_idx = i;

            for (int j = i + 1; j < length; ++j) {
                if (table[j] < table[min_idx]) {
                    min_idx = j;
                }
            }
            long tmp = table[min_idx];
            table[min_idx] = table[i];
            table[i] = tmp;

        }
    }
}
