package com.company.calculation.creators;

import com.company.calculation.*;

import java.util.Objects;
import java.util.Scanner;

public class ExtraSwitch {

    public OutputClass decisionSwitch(){
        Figure figure   = null;
        Prism prism     = null;
        String decision, decision2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the figure: triangle / circle / square");
        decision = scanner.nextLine();
        System.out.println("Choose object: 2D, 3D");
        decision2 = scanner.nextLine();


        if(Objects.equals(decision, "triangle")){
            TriangleCreator creator = new TriangleCreator();
            figure = creator.createTriangle();
        }
        if(Objects.equals(decision, "circle")){
            CircleCreator creator = new CircleCreator();
            figure = creator.createCircle();
        }
        if(Objects.equals(decision, "square")){
            SquareCreator creator = new SquareCreator();
            figure = creator.createSquare();
        }


        switch(decision2){
            case "2D":
            case "2d":
                prism = null;

                break;

            case "3D":
            case "3d":
                PrismCreator creator = new PrismCreator();
                prism = creator.createPrism(figure);

                break;

            default:
                break;
        }

        return new OutputClass(decision, figure, prism);
    }


    public void printSwitch(OutputClass input){

        if(input.getPrism() != null){
            input.getPrism().print();
        }
        if(Objects.equals(input.getStr(), "triangle")){
            ((Triangle)input.getFig()).print();
        }
        if(Objects.equals(input.getStr(), "circle")){
            ((Circle)input.getFig()).print();
        }
        if(Objects.equals(input.getStr(), "square")){
            ((Square)input.getFig()).print();
        }
        else {
            System.out.println("No figure and no prism put.");
        }
    }
}
