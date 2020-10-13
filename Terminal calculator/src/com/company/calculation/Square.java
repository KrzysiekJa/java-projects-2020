package com.company.calculation;


public class Square extends Figure implements Printable {

    public Square(double side){
        this.side = side;
    }

    @Override
    public void print() {
        System.out.println("Square side: " + this.side);
        System.out.println("Square area: " + this.calculateArea());
        System.out.println("Square perimeter: " + this.calculatePerimeter());
    }

    @Override
    public double calculateArea() {
        return this.side * this.side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * this.side;
    }


    private double side;
}
