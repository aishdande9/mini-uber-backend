package com.uber.backend.mini_uber_backend.service;

import com.uber.backend.mini_uber_backend.model.Driver;
import com.uber.backend.mini_uber_backend.model.Rider;
import com.uber.backend.mini_uber_backend.model.Trip;
import com.uber.backend.mini_uber_backend.repository.DriverRepository;
import com.uber.backend.mini_uber_backend.repository.RiderRepository;
import com.uber.backend.mini_uber_backend.repository.TripRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TripService {
    private final RiderRepository riderRepository;
    private final DriverRepository driverRepository;
    private final TripRepository tripRepository;

    public TripService(RiderRepository riderRepository, DriverRepository driverRepository, TripRepository tripRepository) {
        this.riderRepository = riderRepository;
        this.driverRepository = driverRepository;
        this.tripRepository = tripRepository;
    }

    public Driver findNearestAvailableDriver(Rider rider) {
        // Simplified logic: just get first available driver
        return driverRepository.findFirstByAvailableTrue()
                .orElseThrow(() -> new RuntimeException("No drivers available"));
    }

    public void createTrip(Rider rider, Driver driver) {
            Trip trip = new Trip();
            trip.setRider(rider);
            trip.setDriver(driver);
            trip.setStatus("ONGOING");

            tripRepository.save(trip);

            // Mark driver unavailable
            driver.setAvailable(false);
            driverRepository.save(driver);
        }
    }
