package com.adeleke.flyroamer.controller;

import com.adeleke.flyroamer.model.Activity;
import com.adeleke.flyroamer.service.ActivityService;
import com.adeleke.flyroamer.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private CityService cityService;

    // GET /activities - Show activities page with a dropdown for cities
    @GetMapping
    public String showActivitiesPage(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        return "activities_by_city";  // Ensure this template exists
    }

    // GET /activities/by-city/{cityId} - Show activities based on selected city
    @GetMapping("/by-city")
    public String listActivitiesByCity(@RequestParam("cityId") Long cityId, Model model) {
        List<Activity> activities = activityService.getActivitiesByCity(cityId);
        model.addAttribute("activities", activities);
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("selectedCity", cityId);
        return "activities_by_city";
    }

}

