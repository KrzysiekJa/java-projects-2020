package com.company.CarShowroomApp.Api;

import com.company.CarShowroomApp.classes.CarShowroom;
import com.company.CarShowroomApp.classes.Rating;
import com.company.CarShowroomApp.classes.Vehicle;
import com.company.CarShowroomApp.manager.CarShowroomManager;
import com.company.CarShowroomApp.manager.RatingManager;
import com.company.CarShowroomApp.manager.VehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;


@RestController
@RequestMapping("/api")
public class CarShowroomApi {

    private final CarShowroomManager carShowroomManager;
    private final VehicleManager vehicleManager;
    private final RatingManager ratingManager;

    @Autowired
    public CarShowroomApi(CarShowroomManager carShowroomManager, VehicleManager vehicleManager, RatingManager ratingManager) {
        this.carShowroomManager = carShowroomManager;
        this.vehicleManager = vehicleManager;
        this.ratingManager = ratingManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/product")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
        try {
            return vehicleManager.save(vehicle);
        } catch (Exception e) {
            throw new NoResultException();
        }
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public void deleteVehicle(@PathVariable(value = "id") Long id) {
        try {
            vehicleManager.deleteById(id);
        } catch (Exception e) {
            throw new NoResultException();
        }
    }

    @RequestMapping(value = "/product/{id}/rating", method = RequestMethod.GET)
    public double getRating(@PathVariable(value = "id") Long id) {
        try {
            return ratingManager.getAverageRating(id);
        } catch (EmptyResultDataAccessException e) {
            return HttpStatus.NOT_FOUND.value();
        }
    }

    @GetMapping("/product/csv")
    public ResponseEntity<String> getCSV() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain; charset=utf-8");

        try {
            return new ResponseEntity<>(vehicleManager.returnAsCSV(), headers, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @GetMapping("/fulfillment")
    public Iterable<CarShowroom> getFulfillment() {
        try {
            return carShowroomManager.findAll();
        } catch (Exception e) {
            throw new NoResultException();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/fulfillment")
    public CarShowroom saveFulfillment(@RequestBody CarShowroom carShowroom) {
        try {
            return carShowroomManager.save(carShowroom);
        } catch (Exception e) {
            throw new NoResultException();
        }
    }

    @RequestMapping(value = "/fulfillment/{id}", method = RequestMethod.DELETE)
    public void deleteFulfillment(@PathVariable(value = "id") Long id) {
        try {
            carShowroomManager.deleteById(id);
        } catch (Exception e) {
            throw new NoResultException();
        }
    }

    @RequestMapping(value = "/fulfillment/{id}/products", method = RequestMethod.GET)
    public Iterable<Vehicle> getFulfillmentVehicles(@PathVariable(value = "id") Long id) {
        try {
            return carShowroomManager.findById(id).get().getVehicleList();
        } catch (Exception e) {
            throw new NoResultException();
        }
    }

    @RequestMapping(value = "/fulfillment/{id}/fill", method = RequestMethod.GET)
    public double getFulfillmentFill(@PathVariable(value = "id") Long id) {
        int amount;
        double capacity;
        try {
            amount = carShowroomManager.findById(id).get().getVehicleList().size();
            capacity = carShowroomManager.findById(id).get().getCapacity();
        } catch (Exception e) {
            throw new NoResultException();
        }

        return 100 * amount / capacity;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/rating")
    public Rating saveRating(@RequestBody Rating rating) {
        try {
            return ratingManager.save(rating);
        } catch (Exception e) {
            throw new NoResultException();
        }
    }
}
