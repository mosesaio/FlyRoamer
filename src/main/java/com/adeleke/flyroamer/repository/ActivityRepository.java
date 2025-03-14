package com.adeleke.flyroamer.repository;

import com.adeleke.flyroamer.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByCity_Id(Long cityId);
}
