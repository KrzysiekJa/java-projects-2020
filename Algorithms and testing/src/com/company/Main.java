package com.company;

import com.company.FindThree.FindThree;
import com.company.SortingAlgorithms.SortingAlgorithms;
import com.company.Spiral.Spiral;
import com.company.Spot.Spot;
import com.company.Substring.Substring;

public class Main {

    public static void main(String[] args) {
        SortingAlgorithms sorting = new SortingAlgorithms();
        sorting.run();

        Spot spot = new Spot();
        spot.run();

        Substring substring = new Substring();
        substring.run();

        FindThree finder = new FindThree();
        finder.run();

        Spiral spiral = new Spiral();
        spiral.run();
    }
}
