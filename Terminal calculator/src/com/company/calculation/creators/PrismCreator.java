package com.company.calculation.creators;

import com.company.calculation.*;

import java.util.Scanner;

public class PrismCreator {

    public Prism createPrism(Figure figure){

        if (figure == null){
            throw new ArithmeticException("Figure do not exists.");
        }

        Scanner scanner = new Scanner(System.in);
        double high = 0.0;

        System.out.println("Please put the prism' hight value:");


        try{
            high = scanner.nextDouble();
        }
        catch(Exception exc) {
            System.out.println("Thrown exception" + exc);
        }
        scanner.close();


        if(high > 0.0){
            return new Prism(high, figure);
        }
        else {
            throw new ArithmeticException("Value must be greater than 0.");
        }
    }
}
