package com.company.calculation.creators;

import com.company.calculation.Circle;

import java.util.Scanner;

public class CircleCreator {

    public Circle createCircle(){
        Scanner scanner = new Scanner(System.in);
        double radius = 0.0;

        System.out.println("Please put circle' radius value:");


        try{
            radius = scanner.nextDouble();

        } catch(Exception exc){
            System.out.println("Thrown exception" + exc);
        }
        scanner.close();

        if(radius > 0.0){
            return new Circle(radius);
        }
        else{
            throw new ArithmeticException("Value must be greater than 0.");
        }
    }
}
