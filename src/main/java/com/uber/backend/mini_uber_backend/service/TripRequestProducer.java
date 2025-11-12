package com.uber.backend.mini_uber_backend.service;

import com.uber.backend.mini_uber_backend.model.Rider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class TripRequestProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public TripRequestProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTripRequest(Rider rider){

log.info("sending request  for rider"+rider.getName());
kafkaTemplate.send("trip-request",rider);
    }
}
