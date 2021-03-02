package com.company.CarShowroomApp.classes;

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


    public CarShowroom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void summary() {
        for (Vehicle i : vehicleList) {
            i.print();
            System.out.println(" ");
        }
    }
}

