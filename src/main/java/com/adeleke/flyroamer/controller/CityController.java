package com.adeleke.flyroamer.controller;

import com.adeleke.flyroamer.model.City;
import com.adeleke.flyroamer.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    // GET /cities - List all cities
    @GetMapping
    public String listCities(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        return "cities_list";
    }

    // GET /cities/{id} - Show details of a specific city
    @GetMapping("/{id}")
    public String viewCity(@PathVariable Long id, Model model) {
        Optional<City> city = cityService.getCityById(id);
        if (city.isPresent()) {
            model.addAttribute("city", city.get());
            return "city_details";
        } else {
            return "error"; // Handle city not found
        }
    }

    // GET /cities/new - Show form to create a new city
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("city", new City());
        return "create_city";
    }

    // POST /cities - Handle form submission to create a city
    @PostMapping
    public String createCity(@ModelAttribute City city) {
        cityService.saveCity(city);
        return "redirect:/cities";
    }

    // GET /cities/{id}/delete - Delete a city
    @GetMapping("/{id}/delete")
    public String deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return "redirect:/cities";
    }
}
