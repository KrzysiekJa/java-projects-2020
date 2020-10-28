package com.company;

import com.company.classes.CarShowroom;
import com.company.classes.CarShowroomContainer;
import com.company.classes.E_ItemCondition;
import com.company.classes.Vehicle;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Vehicle car1 = new Vehicle("Opel", "Corsa", E_ItemCondition.USED, 20000, 2007, 350000., 40.0);
        Vehicle car2 = new Vehicle("Opel", "Corsa", E_ItemCondition.USED, 27000, 2015, 200000, 35.3);
        Vehicle car3 = new Vehicle("Mercedes", "A3", E_ItemCondition.USED, 35000, 2010, 250000.4, 38.2);
        Vehicle car4 = new Vehicle("BMW", "Seria 3", E_ItemCondition.USED, 40000, 2016, 300000.8, 42.0);
        Vehicle car5 = new Vehicle("BMW", "Seria 7", E_ItemCondition.USED, 55000, 2013, 400000, 38.5);

        CarShowroom speed = new CarShowroom("SpeedDe", 8);
        speed.addProduct(car1);
        speed.addProduct(car2);
        speed.addProduct(car3);
        speed.addProduct(car4);
        speed.addProduct(car5);
        speed.addProduct(car3);

        System.out.println("Max of SpeedDe:" + speed.max());
        System.out.println("Searching: " + speed.search("Seria 3").getModel() + "\n");
        System.out.println("Used cars: " + speed.countByCondition(E_ItemCondition.USED));
        speed.summary();


        Vehicle car11 = new Vehicle("Ford", "Mondeo", E_ItemCondition.NEW, 100000, 2019, 1200.0, 35.0);
        Vehicle car12 = new Vehicle("Ford", "Focus 1.6", E_ItemCondition.NEW, 120000, 2019, 2000, 35.3);
        Vehicle car13 = new Vehicle("Ford", "Fiesta", E_ItemCondition.NEW, 115000, 2020, 2500.1, 36.2);
        Vehicle car14 = new Vehicle("Ford", "Fiesta 1.5", E_ItemCondition.NEW, 150000, 2019, 1300.5, 40.1);
        Vehicle car15 = new Vehicle("Hammer", "Hammve", E_ItemCondition.NEW, 300000, 2018, 1500, 45.5);

        CarShowroom american = new CarShowroom("AmericanCar", 16);
        american.addProduct(car11);
        american.addProduct(car12);
        american.addProduct(car12);
        american.addProduct(car12);
        american.addProduct(car13);
        american.addProduct(car13);
        american.addProduct(car14);
        american.addProduct(car14);
        american.addProduct(car15);
        american.removeProduct(american.search("Hammve"));
        american.removeProduct(american.search("Fiesta"));

        System.out.println("\n\nMax of SpeedDe:" + american.max());
        american.summary();
        System.out.println(american.sortByName().stream().map(Vehicle::getModel).collect(Collectors.toList()));


        CarShowroom newCar = new CarShowroom("New Car", 25);
        newCar.addProduct(new Vehicle("Fiat", "Maluch", E_ItemCondition.DAMAGED, 1000, 1988, 550000, 31.5));
        newCar.addProduct(new Vehicle("Fiat", "Panda", E_ItemCondition.USED, 1000, 2008, 250000, 41.5));
        System.out.println("Sorting New Car by amount: " + newCar.sortByAmount());
        newCar.getProduct(american.search("Maluch"));
        System.out.println(" ");


        CarShowroomContainer showrooms = new CarShowroomContainer();
        showrooms.addCenter(speed);
        showrooms.addCenter(american);
        showrooms.addCenter(newCar);
        CarShowroom newer = new CarShowroom("New One", 20);
        showrooms.addCenter(newer);

        System.out.println("Summary:");
        showrooms.summary();

        System.out.println("Empty showrooms: " + showrooms.findEmpty());
        showrooms.removeCenter(newCar.getName());
    }
}
