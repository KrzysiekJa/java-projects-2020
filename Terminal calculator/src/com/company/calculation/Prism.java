package com.company.calculation;

public class Prism implements Printable{

    public Prism(double high, Figure base){
        this.high = high;
        this.base = base;
    }

    @Override
    public void print() {
        System.out.println("Prism high: " + this.high);
        System.out.println("Prism volume: " + this.calculateVolume());
        System.out.println("Prism area: " + this.calculateArea());
    }

    public double calculateArea() {
        return 2 * base.calculateArea() + high * base.calculatePerimeter();
    }

    public double calculateVolume() {
        return high * base.calculateArea();
    }


    private double high;
    private Figure base;
}
