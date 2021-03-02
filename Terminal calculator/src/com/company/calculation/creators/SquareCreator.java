package com.company.calculation.creators;

import com.company.calculation.Square;

import java.util.Scanner;

public class SquareCreator {

    public Square createSquare(){
        Scanner scanner = new Scanner(System.in);
        double side = 0.0;

        System.out.println("Please put square' side value:");


        try{
            side = Double.parseDouble(scanner.nextLine());

        } catch(Exception exc){
            System.out.println("Thrown exception" + exc);
        }
        scanner.close();

        if(side > 0.0){
            return new Square(side);
        }else{
            throw new ArithmeticException("Value must be greater than 0.");
        }
    }
}
