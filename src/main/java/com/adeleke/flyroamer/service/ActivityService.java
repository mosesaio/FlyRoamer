//package com.adeleke.flyroamer.service;
//
//import com.adeleke.flyroamer.model.Activity;
//import com.adeleke.flyroamer.repository.ActivityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ActivityService {
//    @Autowired
//    private ActivityRepository activityRepository;
//
//    public List<Activity> getAllActivities() {
//        return activityRepository.findAll();
//    }
//
//    public Optional<Activity> getActivityById(Long id) {
//        return activityRepository.findById(id);
//    }
//
//    public List<Activity> getActivitiesByCity(Long cityId) {
//        return activityRepository.findByCity_Id(cityId);
//    }
//}

package com.adeleke.flyroamer.service;

import com.adeleke.flyroamer.model.Activity;
import com.adeleke.flyroamer.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public List<Activity> getActivitiesByCity(Long cityId) {
        return activityRepository.findByCity_Id(cityId);
    }
}


