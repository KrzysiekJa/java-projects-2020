package com.company.SortingAlgorithms;

public class ShellSort implements I_SortingAlgorithm {

    @Override
    public void sort(long[] table) {
        int length = table.length;

        for(int gap = length/2; gap > 0; gap /= 2){
            for(int i = gap; i < length; ++i){
                 long tmp = table[i];
                 int j;

                 for(j = i; j >= gap && table[j - gap] > tmp; j -= gap){
                     table[j] = table[j - gap];
                 }
                 table[j] = tmp;
            }
        }
    }
}
