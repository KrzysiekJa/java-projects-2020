package com.company.CarShowroomApp.classes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "RATING")
@Data
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "Value", nullable=false)
    private int value;
    @Column(name = "Carshowroom", nullable=false)
    private long carshowroom;
}