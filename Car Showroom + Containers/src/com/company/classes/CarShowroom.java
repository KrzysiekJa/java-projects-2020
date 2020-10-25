package com.company.classes;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarShowroom {
    public CarShowroom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void addProduct(Vehicle product) {

        if (++amount > capacity) {
            --amount;
            System.err.println("The capacity of car showroom has been exceeded.");
        }
        if (vehicleMap.containsKey(product)) {
            Integer i = vehicleMap.get(product);
            vehicleMap.replace(product, ++i);
        } else {
            vehicleMap.put(product, 1);
        }
    }

    public void getProduct(Vehicle vehicle) {

        if (vehicleMap.containsKey(vehicle)) {
            Integer i = vehicleMap.get(vehicle);
            if (--i == 0) {
                vehicleMap.remove(vehicle);
                --amount;
            } else {
                vehicleMap.replace(vehicle, i);
                --amount;
            }
        }
    }

    public void removeProduct(Vehicle vehicle) {

        if (vehicleMap.containsKey(vehicle)) {
            amount -= vehicleMap.get(vehicle);
            vehicleMap.remove(vehicle);
        }
    }

    public Vehicle search(String model) {

        Comparator<String> compareStrings = Comparator.naturalOrder();

        for (Vehicle i : vehicleMap.keySet()) {

            if (compareStrings.compare(model, i.getModel()) > 0) {
                return i;
            }
        }
        return null;
    }

    public List<Vehicle> searchPartial(String p) {
        List<Vehicle> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(p);

        for (Vehicle i : vehicleMap.keySet()) {
            Matcher match = pattern.matcher(i.getModel());

            if (match.find()) {
                result.add(i);
            }
        }
        return result;
    }

    public int countByCondition(E_ItemCondition condition) {
        int result = 0;

        for (Vehicle i : vehicleMap.keySet()) {

            if (i.getState() == condition) {
                ++result;
            }
        }
        return result;
    }

    public void summary() {
        for (Vehicle i : vehicleMap.keySet()) {
            i.print();
            System.out.println(" ");
        }
    }

    public PriorityQueue<Vehicle> sortByName() {

        return new PriorityQueue<>(vehicleMap.keySet());
    }

    public PriorityQueue<Integer> sortByAmount() {

        return new PriorityQueue<>(vehicleMap.values());
    }

    public String max() {
        return Collections.max(vehicleMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey().getModel();
    }

    public int getAmount() {
        return amount;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    private final String name;
    private HashMap<Vehicle, Integer> vehicleMap = new HashMap<Vehicle, Integer>();
    private final int capacity;
    private int amount = 0;
}
