package com.company.CarShowroomApp.DAO;

import com.company.CarShowroomApp.classes.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends CrudRepository<Vehicle, Long> {
}
