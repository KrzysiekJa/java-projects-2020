package com.company.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarShowroomContainer {

    public CarShowroomContainer() {
    }

    public void addCenter(CarShowroom showroom) {
        showrooms.put(showroom.getName(), showroom);
    }

    public void removeCenter(String name) {
        showrooms.remove(name);
    }

    public List<String> findEmpty() {
        List<String> result = new ArrayList<>();

        for (CarShowroom i : showrooms.values()) {

            if (i.getAmount() == 0) {
                result.add(i.getName());
            }
        }
        return result;
    }

    public void summary() {
        for (String i : showrooms.keySet()) {
            double result = (1.0 * showrooms.get(i).getAmount()) / showrooms.get(i).getCapacity();
            System.out.println(i + ": " + result);
        }
    }


    public HashMap<String, CarShowroom> showrooms = new HashMap<>();

}
