package com.company.calculation.creators;

import com.company.calculation.Triangle;

import java.util.Arrays;
import java.util.Scanner;

public class TriangleCreator {

    public Triangle createTriangle() {
        Scanner scanner = new Scanner(System.in);
        Double[] sides = {0.0, 0.0, 0.0};
        int i = 0;


        System.out.println("Please put a, b, c side of triangle:");
        sides[0] = scanner.nextDouble();
        sides[1] = scanner.nextDouble();
        sides[2] = scanner.nextDouble();

        try{
            do {
                if (sides[i] <= 0.0) {
                    throw new ArithmeticException("Value must be greater than 0.");
                }
                ++i;
            }while(i < 3);
        } catch(Exception exc){
           System.out.println("Thrown exception" + exc);
        }
        scanner.close();


        Arrays.sort(sides);

        if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) {
            return new Triangle(sides[0], sides[1], sides[2]);
        }
        else {
            throw new ArithmeticException("Values do not meet Pythagoras theorem.");
        }
    }
}
