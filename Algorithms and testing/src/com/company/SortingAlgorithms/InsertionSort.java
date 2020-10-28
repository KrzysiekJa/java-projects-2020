package com.company.SortingAlgorithms;

public class InsertionSort implements I_SortingAlgorithm {

    @Override
    public void sort(long[] table) {
        int length = table.length;

        for (int i = 1; i < length; ++i) {
            long key = table[i];
            int j = i - 1;

            while (j >= 0 && table[j] > key) {
                table[j + 1] = table[j];
                j -= 1;
            }
            table[j + 1] = key;
        }
    }
}
