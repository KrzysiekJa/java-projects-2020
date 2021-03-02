package com.company.CarShowroomApp.classes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Vehicle")
@Data
@NoArgsConstructor
public class Vehicle implements Comparable<Vehicle> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "Mark", nullable=false)
    private String mark;
    @Column(name = "Model", nullable=false)
    private String model;
    @Column(name = "Price", nullable=false)
    private double price;
    @Column(name = "ProductionYear", nullable=false)
    private int productionYear;
    @Column(name = "Mileage", nullable=false)
    private double mileage;
    @Column(name = "EngineCapacity", nullable=false)
    private double engineCapacity;
    @Column(name = "Carshowroom", nullable=false)
    private long Showroom;


    public Vehicle(String mark, String model, double price, int productionYear,
                   double mileage, double engineCapacity, long Showroom) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
        this.Showroom = Showroom;
    }

    public void print() {
        System.out.println("Vehicle data: " + mark + " " + model);
        System.out.println("Price: " + price + " Year: " + productionYear);
        System.out.println("Mileage: " + mileage + " Capacity: " + engineCapacity);
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.model.compareTo(o.model);
    }
}

