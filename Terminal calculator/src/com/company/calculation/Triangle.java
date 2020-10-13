package com.company.calculation;


public class Triangle extends Figure implements Printable {

    public Triangle(Double aSide, Double bSide, Double cSide){
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
        this.perimeter = aSide + bSide + cSide;
    }

    @Override
    public void print() {
        System.out.println("Triangle sides: " + this.aSide + this.bSide + this.cSide);
        System.out.println("Triangle area : " + this.calculateArea());
        System.out.println("Triangle perimeter: " + this.calculatePerimeter());
    }

    @Override
    public double calculateArea() {
        double p = perimeter/2;
        return Math.sqrt( p*(p - aSide)*(p - bSide)*(p - cSide));
    }

    @Override
    public double calculatePerimeter() {
        double result = 0.0;

        try{
            result = this.perimeter;
        } catch (Exception exc){
            System.out.println("Perimeter still not computed! Parameters needed!");
        }

        return result;
    }


    private double aSide;
    private double bSide;
    private double cSide;
    private double perimeter;
}
