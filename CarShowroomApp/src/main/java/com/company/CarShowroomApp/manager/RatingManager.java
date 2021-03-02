package com.company.CarShowroomApp.manager;

import com.company.CarShowroomApp.DAO.RatingDAO;
import com.company.CarShowroomApp.classes.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingManager {

    private final RatingDAO ratingDAO;

    @Autowired
    public RatingManager(RatingDAO ratingDAO) {
        this.ratingDAO = ratingDAO;
    }

    public Optional<Rating> findById(Long id){
        return ratingDAO.findById(id);
    }

    public Iterable<Rating> findAll(){
        return ratingDAO.findAll();
    }

    public Rating save(Rating rating){
        return ratingDAO.save(rating);
    }

    public void deleteById(Long id){
        ratingDAO.deleteById(id);
    }

    public double getAverageRating(Long index){
        int amount = 0;
        double rating = 0.0;

        Iterable<Rating> ratings = ratingDAO.findAll();
        for (Rating elem : ratings) {
            if(index == elem.getCarshowroom()){
                rating += elem.getValue();
                ++amount;
            }
        }

        return rating/amount;
    }
}
