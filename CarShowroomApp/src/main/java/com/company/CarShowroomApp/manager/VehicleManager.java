package com.company.CarShowroomApp.manager;

import com.company.CarShowroomApp.DAO.VehicleDAO;
import com.company.CarShowroomApp.classes.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleManager {

    private final VehicleDAO vehicleDAO;

    @Autowired
    public VehicleManager(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public Optional<Vehicle> findById(Long id) {
        return vehicleDAO.findById(id);
    }

    public Iterable<Vehicle> findAll() {
        return vehicleDAO.findAll();
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleDAO.save(vehicle);
    }

    public void deleteById(Long id) {
        vehicleDAO.deleteById(id);
    }

    public String returnAsCSV() {
        Iterable<Vehicle> vehicles = vehicleDAO.findAll();
        StringBuilder result = new StringBuilder();

        for (Vehicle veh : vehicles) {

            result.append(veh.getId()).append(",");
            result.append(veh.getMark()).append(",");
            result.append(veh.getModel()).append(",");
            result.append(veh.getPrice()).append(",");
            result.append(veh.getProductionYear()).append(",");
            result.append(veh.getMileage()).append(",");
            result.append(veh.getEngineCapacity()).append(",");
            result.append(veh.getShowroom()).append("\n");
        }

        return result.toString();
    }
}
