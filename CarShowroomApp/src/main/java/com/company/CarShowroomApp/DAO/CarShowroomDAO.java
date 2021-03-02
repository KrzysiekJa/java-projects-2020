package com.company.CarShowroomApp.DAO;

import com.company.CarShowroomApp.classes.CarShowroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarShowroomDAO extends CrudRepository<CarShowroom, Long> {
}
