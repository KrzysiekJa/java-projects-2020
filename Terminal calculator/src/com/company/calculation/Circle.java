package com.company.calculation;

public class Circle extends Figure implements Printable {

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public void print() {
        System.out.println("Circle radius: " + this.radius);
        System.out.println("Circle area  : " + this.calculateArea());
        System.out.println("Circle perimeter: " + this.calculatePerimeter());
    }

    @Override
    public double calculateArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }


    private double radius;
}
