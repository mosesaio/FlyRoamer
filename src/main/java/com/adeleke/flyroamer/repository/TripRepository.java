package com.adeleke.flyroamer.repository;

import com.adeleke.flyroamer.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByTripNameContaining(String keyword);
}
