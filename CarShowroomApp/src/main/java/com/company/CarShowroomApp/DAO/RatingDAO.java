package com.company.CarShowroomApp.DAO;

import com.company.CarShowroomApp.classes.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingDAO extends CrudRepository<Rating, Long> {
}
