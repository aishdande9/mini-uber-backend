package com.uber.backend.mini_uber_backend.service;

import com.uber.backend.mini_uber_backend.model.Driver;
import com.uber.backend.mini_uber_backend.model.Rider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class TripRequestConsumer {

    private final TripService tripService;

    public TripRequestConsumer(TripService tripService) {
        this.tripService = tripService;
    }
    @KafkaListener(topics = "trip-requests", groupId = "uber-group")
    public void consumeTripRequest(Rider rider){
        log.info("received trip request for rider :"+rider.getName());

        Driver driver = tripService.findNearestAvailableDriver(rider);
        tripService.createTrip(rider, driver);

        System.out.println("Trip created for rider " + rider.getName() + " with driver " + driver.getName());
    }

    }

