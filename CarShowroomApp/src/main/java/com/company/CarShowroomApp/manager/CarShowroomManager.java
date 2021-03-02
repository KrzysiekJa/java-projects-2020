package com.company.CarShowroomApp.manager;

import com.company.CarShowroomApp.DAO.CarShowroomDAO;
import com.company.CarShowroomApp.classes.CarShowroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarShowroomManager {

    private final CarShowroomDAO carShowroomDAO;

    @Autowired
    public CarShowroomManager(CarShowroomDAO carShowroomDAO) {
        this.carShowroomDAO = carShowroomDAO;
    }

    public Optional<CarShowroom> findById(Long id){
        return carShowroomDAO.findById(id);
    }

    public Iterable<CarShowroom> findAll(){
        return carShowroomDAO.findAll();
    }

    public CarShowroom save(CarShowroom carShowroom){
        return carShowroomDAO.save(carShowroom);
    }

    public void deleteById(Long id){
        carShowroomDAO.deleteById(id);
    }
}
