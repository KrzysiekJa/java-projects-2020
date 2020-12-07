package com.company.Classes;

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

        for (Vehicle elem : vehicleMap.keySet()) {
            if (product.compareTo(elem) == 0) {
                Integer i = vehicleMap.get(elem);
                vehicleMap.replace(elem, ++i);
                return;
            }
        }

        vehicleMap.put(product, 1);
    }

    public void getProduct(Vehicle vehicle) {

        if (vehicleMap.containsKey(vehicle)) {
            Integer i = vehicleMap.get(vehicle);
            if (--i == 0) {
                vehicleMap.remove(vehicle);
            } else {
                vehicleMap.replace(vehicle, i);
            }
            --amount;
        }
    }

    public void removeProduct(String model) {

        Comparator<String> compareStrings = Comparator.naturalOrder();

        for (Vehicle i : vehicleMap.keySet()) {
            if (compareStrings.compare(i.getModel(), model) == 0) {
                amount -= vehicleMap.get(i);
                vehicleMap.remove(i);
                return;
            }
        }
    }

    public Vehicle search(String model) {

        Comparator<String> compareStrings = Comparator.naturalOrder();

        for (Vehicle i : vehicleMap.keySet()) {

            if (compareStrings.compare(i.getModel(), model) > 0) {
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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vehicle> getVehicleMapSet() {
        return vehicleMap.keySet();
    }

    private String name;
    private Map<Vehicle, Integer> vehicleMap = new HashMap<>();
    private int capacity;
    private int amount = 0;
}
