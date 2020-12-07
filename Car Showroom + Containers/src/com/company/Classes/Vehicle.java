package com.company.Classes;

public class Vehicle implements Comparable<Vehicle> {

    public Vehicle(String mark, String model, E_ItemCondition state, double price, int productionYear,
                   double mileage, double engineCapacity) {
        this.mark = mark;
        this.model = model;
        this.state = state;
        this.price = price;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
    }

    public void print() {
        System.out.println("Vehicle data: " + mark + " " + model);
        System.out.println("State: " + state);
        System.out.println("Price: " + price + " Year: " + productionYear);
        System.out.println("Mileage: " + mileage + " Capacity: " + engineCapacity);
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.model.compareTo(o.model);
    }

    public String getMark() {
        return mark;
    }

    public double getPrice() {
        return price;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public double getMileage() {
        return mileage;
    }

    public String getModel() {
        return model;
    }

    public E_ItemCondition getState() {
        return state;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setState(E_ItemCondition state) {
        this.state = state;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    private String mark;
    private String model;
    private E_ItemCondition state;
    private double price;
    private int productionYear;
    private double mileage;
    private double engineCapacity;
}
