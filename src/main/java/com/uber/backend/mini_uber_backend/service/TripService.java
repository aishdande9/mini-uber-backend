package com.uber.backend.mini_uber_backend.service;

import com.uber.backend.mini_uber_backend.model.Driver;
import com.uber.backend.mini_uber_backend.model.Rider;
import com.uber.backend.mini_uber_backend.model.Trip;
import com.uber.backend.mini_uber_backend.repository.DriverRepository;
import com.uber.backend.mini_uber_backend.repository.RiderRepository;
import com.uber.backend.mini_uber_backend.repository.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TripService {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private TripRepository tripRepository;

    public Rider addRider(Rider rider){
       return riderRepository.save(rider);
    }

    public List<Rider> getAllRiders(){
        return riderRepository.findAll();
    }

    public Driver addDriver(Driver driver){
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers(){
        return  driverRepository.findAll();
    }

    public Trip requestTrip(Trip trip){
        // Fetch rider from DB to ensure it's managed by JPA
//        Rider rider = riderRepository.findById(trip.getRider().getId())
//                .orElseThrow(() -> new RuntimeException("Rider not found"));
//        trip.setRider(rider);
//        log.info("find rider id :"+trip.getRider().getId());

        List<Driver> availableDriver = driverRepository.findByAvailableTrue();
        if(!availableDriver.isEmpty()){
            Driver driver = availableDriver.get(0);
            driver.setAvailable(false);
          trip.setDriver(driver);
          trip.setStatus("ASSIGNED");
          driverRepository.save(driver);
        }else{
            trip.setStatus("REQUESTED");
        }

        return tripRepository.save(trip);
    }

}
