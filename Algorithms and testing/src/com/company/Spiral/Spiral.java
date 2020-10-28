package com.company.Spiral;


public class Spiral {

    int[] spriralFunction(int[][] matrix) {
        if(matrix.length == 0){
            throw new EmptyMatrixException("Table has less elements than 3.");
        }

        int i, j = 0, k = 0, len = 0;
        int high = matrix.length;
        int width = matrix[0].length;
        int[] results = new int[high * width];


        while (j < high && k < width) {

            for (i = j; i < high; ++i) {
                results[len++] = matrix[i][k];
            }
            ++k;

            for (i = k; i < width; ++i) {
                results[len++] = matrix[high - 1][i];
            }
            --high;

            if (k < width) {
                for (i = high - 1; i >= j; --i) {
                    results[len++] = matrix[i][width - 1];
                }
                --width;
            }

            if (j < high) {
                for (i = width - 1; i >= k; --i) {
                    results[len++] = matrix[j][i];
                }
                ++j;
            }
        }

        return results;
    }

    private static void print(int[][] matrix){

        for (int[] tab: matrix) {
            for(int elem: tab){
                System.out.print(elem + " ");
            }
            System.out.println(" ");
        }
    }


    public void run() {
        int[][] tab = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        print(tab);


        int[] results = new int[tab.length * tab[0].length];
        try {
            results = spriralFunction(tab);
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception thrown." + exception);
        }


        System.out.println("\nSpiral searching result.");
        for (int elem : results) {
            System.out.print(elem + " ");
        }
    }
}
