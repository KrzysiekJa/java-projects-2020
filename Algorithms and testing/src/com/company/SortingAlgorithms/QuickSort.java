package com.company.SortingAlgorithms;

public class QuickSort implements I_SortingAlgorithm {

    private long partition(long[] arr, long low, long high) {
        long pivot = arr[(int) high];
        int i = (int) (low - 1);

        for (int j = (int) low; j < high; ++j) {

            if (arr[j] < pivot) {
                ++i;
                long tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        long tmp = arr[i + 1];
        arr[i + 1] = arr[(int) high];
        arr[(int) high] = tmp;

        return i + 1;
    }

    private void sorting(long[] table, long low, long high) {
        if (low < high) {
            long piv = partition(table, low, high);

            sorting(table, low, piv - 1);
            sorting(table, piv + 1, high);
        }
    }

    @Override
    public void sort(long[] table) {
        sorting(table, 0, table.length - 1);
    }
}
