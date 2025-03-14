package com.adeleke.flyroamer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "activities")
@Data // Lombok annotation to generate getters, setters, toString, etc.
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 255)
    private String description;

    @Getter
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToMany(mappedBy = "activities")
    private List<Trip> trips;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}

