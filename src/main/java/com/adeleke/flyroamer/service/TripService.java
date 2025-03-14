package com.adeleke.flyroamer.service;

import com.adeleke.flyroamer.model.Trip;
import com.adeleke.flyroamer.model.City;
import com.adeleke.flyroamer.model.Activity;
import com.adeleke.flyroamer.repository.TripRepository;
import com.adeleke.flyroamer.repository.CityRepository;
import com.adeleke.flyroamer.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public List<Trip> searchTripsByName(String keyword) {
        return tripRepository.findByTripNameContaining(keyword);
    }

    public Trip saveTrip(Trip trip, List<Long> cityIds, List<Long> activityIds) {
        List<City> selectedCities = cityRepository.findAllById(cityIds);
        List<Activity> selectedActivities = activityRepository.findAllById(activityIds);

        trip.setCities(selectedCities);
        trip.setActivities(selectedActivities);

        return tripRepository.save(trip);
    }


    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<Activity> getActivitiesByCities(List<Long> cityIds) {
        return activityRepository.findAll().stream()
                .filter(activity -> cityIds.contains(activity.getCity().getId()))
                .collect(Collectors.toList());
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Trip updateTrip(Long tripId, String tripName, String description, List<Long> cityIds, List<Long> activityIds) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
            trip.setTripName(tripName);

            List<City> selectedCities = cityRepository.findAllById(cityIds);
            List<Activity> selectedActivities = activityRepository.findAllById(activityIds)
                    .stream()
                    .filter(activity -> selectedCities.contains(activity.getCity()))
                    .collect(Collectors.toList());

            trip.setCities(selectedCities);
            trip.setActivities(selectedActivities);
            return tripRepository.save(trip);
        }
        return null;
    }
}
