package com.adeleke.flyroamer.repository;

import com.adeleke.flyroamer.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);
}
