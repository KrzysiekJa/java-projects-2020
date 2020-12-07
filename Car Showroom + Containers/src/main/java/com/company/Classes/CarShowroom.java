package com.company.Classes;

import com.company.DAO.CarShowroomDAO;
import com.company.DAO.DAO;
import com.company.DAO.VehicleDAO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "CarShowroom")
@Data
@NoArgsConstructor
public class CarShowroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Capacity", nullable = false)
    private int capacity;
    @OneToMany(mappedBy = "Showroom", fetch = FetchType.EAGER)
    private List<Vehicle> vehicleList = new ArrayList<>();
    @Transient
    private int amount = 0;
    @Transient
    private int counted;
    @Transient
    private double average;


    public CarShowroom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void addProduct(Vehicle product) {
        final DAO<Vehicle> vehicleDAO = new VehicleDAO();

        if (++amount > capacity) {
            --amount;
            System.err.println("The capacity of car showroom has been exceeded.");
        }

        product.setId(id);
        vehicleDAO.save(product);
    }

    public void removeProduct(Vehicle veh) {
        final DAO<Vehicle> vehicleDAO = new VehicleDAO();

        if (vehicleList.contains(veh)) {
            vehicleDAO.delete(veh);
            --amount;
        }
    }

    public Vehicle search(String model) {
        Comparator<String> compareStrings = Comparator.naturalOrder();

        for (Vehicle i : vehicleList) {
            if (compareStrings.compare(i.getModel(), model) > 0) {
                return i;
            }
        }
        return null;
    }

    public void summary() {
        for (Vehicle i : vehicleList) {
            i.print();
            System.out.println(" ");
        }
    }

    public PriorityQueue<Vehicle> sortByName() {
        return new PriorityQueue<>(vehicleList);
    }

    public int getCounted() {
        final DAO<CarShowroom> carShowroomDAO = new CarShowroomDAO();
        counted = carShowroomDAO.count(id);
        return carShowroomDAO.count(id);
    }

    public double getAverageBy() {
        final DAO<CarShowroom> carShowroomDAO = new CarShowroomDAO();
        if (carShowroomDAO.count(id) > 0) {
            average = (double) carShowroomDAO.sum(id) / carShowroomDAO.count(id);
            return (double) carShowroomDAO.sum(id) / carShowroomDAO.count(id);
        } else {
            average = 0.0;
            return 0.0;
        }
    }
}

