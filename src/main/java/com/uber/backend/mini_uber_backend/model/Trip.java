package com.uber.backend.mini_uber_backend.model;

import jakarta.persistence.*;
import lombok.*;

import javax.xml.stream.Location;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Rider rider;
    @ManyToOne
    private Driver driver;

    private String pickupLocation;
    private String dropOffLocation;


    private String status;

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
