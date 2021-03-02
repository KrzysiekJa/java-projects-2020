package com.company.calculation.creators;

import com.company.calculation.*;

import java.util.Objects;
import java.util.Scanner;

public class ExtraSwitch {

    public OutputClass decisionSwitch(){
        Figure figure   = null;
        Prism prism     = null;
        String decisionFig, decisionDim;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the figure: triangle / circle / square");
        decisionFig = String.valueOf(scanner.nextLine());
        System.out.println("Choose object: 2D, 3D");
        decisionDim = String.valueOf(scanner.nextLine());


        if(Objects.equals(decisionFig, "triangle") || Objects.equals(decisionFig, "t")){
            TriangleCreator creator = new TriangleCreator();
            figure = creator.createTriangle();
        }
        if(Objects.equals(decisionFig, "circle") || Objects.equals(decisionFig, "c")){
            CircleCreator creator = new CircleCreator();
            figure = creator.createCircle();
        }
        if(Objects.equals(decisionFig, "square") || Objects.equals(decisionFig, "s")){
            SquareCreator creator = new SquareCreator();
            figure = creator.createSquare();
        }


        switch(decisionDim){
            case "2D":
            case "2d":
            case "2":
                prism = null;

                break;

            case "3D":
            case "3d":
            case "3":
                PrismCreator creator = new PrismCreator();
                prism = creator.createPrism(figure);

                break;

            default:
                break;
        }
        scanner.close();

        return new OutputClass(decisionFig, figure, prism);
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
            System.out.println("No figure and no prism has been put.");
        }
    }
}
