//package com.adeleke.flyroamer.service;
//
//import com.adeleke.flyroamer.model.City;
//import com.adeleke.flyroamer.repository.CityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CityService {
//    @Autowired
//    private CityRepository cityRepository;
//
//    public List<City> getAllCities() {
//        return cityRepository.findAll();
//    }
//
//    public Optional<City> getCityById(Long id) {
//        return cityRepository.findById(id);
//    }
//
//    public Optional<City> getCityByName(String name) {
//        return cityRepository.findByName(name);
//    }
//
//    public City saveCity(City city) {
//        return cityRepository.save(city);
//    }
//
//    public void deleteCity(Long id) {
//        cityRepository.deleteById(id);
//    }
//}

package com.adeleke.flyroamer.service;

import com.adeleke.flyroamer.model.City;
import com.adeleke.flyroamer.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
}}
