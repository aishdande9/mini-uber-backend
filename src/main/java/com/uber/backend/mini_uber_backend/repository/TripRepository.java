package com.uber.backend.mini_uber_backend.repository;

import com.uber.backend.mini_uber_backend.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
