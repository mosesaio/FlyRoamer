//package com.adeleke.flyroamer.controller;
//
//import com.adeleke.flyroamer.model.Trip;
//import com.adeleke.flyroamer.service.ActivityService;
//import com.adeleke.flyroamer.service.CityService;
//import com.adeleke.flyroamer.service.TripService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/trips")
//public class TripController {
//    @Autowired
//    private TripService tripService;
//
//    CityService cityService;
//    ActivityService activityService;
//
//    // GET /trips - List all trips (No login required)
//    @GetMapping
//    public String listTrips(Model model) {
//        model.addAttribute("trips", tripService.getAllTrips());
//        return "view_trips";
//    }
//
//    // GET /trips/{id} - Show details of a specific trip
//    @GetMapping("/{id}")
//    public String viewTrip(@PathVariable Long id, Model model) {
//        Optional<Trip> trip = tripService.getTripById(id);
//        if (trip.isPresent()) {
//            model.addAttribute("trip", trip.get());
//            return "trip_details";
//        } else {
//            return "error"; // Handle trip not found
//        }
//    }
//
//    // GET /trips/new - Show form to create a new trip
//    @GetMapping("/new")
//    public String showCreateForm(Model model) {
//        model.addAttribute("trip", new Trip());
//        model.addAttribute("cities", cityService.getAllCities());
//        model.addAttribute("activities", activityService.getAllActivities());
//        return "plan_trip";
//    }
//
////    List<Trip> trips = tripService.getAllTrips();
//
//
//
//    // POST /trips - Handle form submission to create a trip
////    @PostMapping
////    public String createTrip(@RequestParam String tripName,
////                             @RequestParam List<Long> cityIds,
////                             @RequestParam List<Long> activityIds) {
////        tripService.saveTrip(tripName, cityIds, activityIds);
////        return "redirect:/trips";
////    }
//
//    // GET /trips/{id}/edit - Show form to edit an existing trip
//    @GetMapping("/{id}/edit")
//    public String showEditForm(@PathVariable Long id, Model model) {
//        Optional<Trip> trip = tripService.getTripById(id);
//        if (trip.isPresent()) {
//            model.addAttribute("trip", trip.get());
//            model.addAttribute("cities", cityService.getAllCities());  // Ensure cities are available
//            model.addAttribute("activities", activityService.getAllActivities());  // Ensure activities are available
//            return "edit_trip";  // Ensure this matches the actual template name
//        } else {
//            return "error"; // Handle trip not found
//        }
//    }
//
//
//    // POST /trips/{id}/update - Handle form submission to update a trip


////    @PostMapping("/{id}/update")
////    public String updateTrip(@PathVariable Long id,
////                             @RequestParam String tripName,
////                             @RequestParam List<Long> cityIds,
////                             @RequestParam List<Long> activityIds) {
////        tripService.updateTrip(id, tripName, cityIds, activityIds);
////        return "redirect:/trips";
////    }
//
//    // GET /trips/{id}/delete - Delete a trip
//    @GetMapping("/{id}/delete")
//    public String deleteTrip(@PathVariable Long id) {
//        tripService.deleteTrip(id);
//        return "redirect:/trips";
//    }

//
//
//    @PostMapping public String createTrip(@ModelAttribute Trip trip, @RequestParam("cityIds") List<Long> cityIds, @RequestParam("activityIds") List<Long> activityIds) { tripService.saveTrip(trip, cityIds, activityIds); return "redirect:/trips";
//    }
//
//    @PostMapping("/{id}/update") public String updateTrip(@PathVariable Long id, @ModelAttribute Trip trip, @RequestParam("cityIds") List<Long> cityIds, @RequestParam("activityIds") List<Long> activityIds) { tripService.updateTrip(id, trip.getTripName(), cityIds, activityIds); return "redirect:/trips"; }
//
//
//
//
//
//
//}




package com.adeleke.flyroamer.controller;


import org.springframework.web.bind.annotation.RequestParam;
import com.adeleke.flyroamer.model.Trip;
import com.adeleke.flyroamer.service.TripService;
import com.adeleke.flyroamer.service.CityService;
import com.adeleke.flyroamer.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @Autowired
    private CityService cityService;

    @Autowired
    private ActivityService activityService;

    // GET /trips/new - Show form to create a new trip
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("activities", activityService.getAllActivities());
        return "plan_trip";
    }

    // GET /trips/{id}/edit - Show form to edit an existing trip
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Trip> trip = tripService.getTripById(id);
        if (trip.isPresent()) {
            model.addAttribute("trip", trip.get());
            model.addAttribute("cities", cityService.getAllCities());
            model.addAttribute("activities", activityService.getAllActivities());
            return "edit_trip";
        } else {
            return "error";
        }
    }

    @GetMapping
    public String listTrips(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "view_trips";
    }


    @GetMapping("/{id}/delete")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "redirect:/trips";
    }

    @PostMapping("/save")
    public String saveTrip(@RequestParam String tripName,
                           @RequestParam(required = false, defaultValue = "No description provided") String description,
                           @RequestParam List<Long> cityIds,
                           @RequestParam List<Long> activityIds) {
        Trip trip = new Trip();
        trip.setTripName(tripName);
        trip.setDescription(description);
        tripService.saveTrip(trip, cityIds, activityIds);
        return "redirect:/trips";
    }

    @PostMapping("/{id}/update")
    public String updateTrip(@PathVariable Long id,
                             @RequestParam String tripName,
                             @RequestParam(required = false, defaultValue = "No description provided") String description,
                             @RequestParam List<Long> cityIds,
                             @RequestParam List<Long> activityIds) {
        tripService.updateTrip(id, tripName, description, cityIds, activityIds);
        return "redirect:/trips";
    }





}






