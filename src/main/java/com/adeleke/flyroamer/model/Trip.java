package com.adeleke.flyroamer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "trips")
@Data // Lombok annotation to generate getters, setters, toString, etc.
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String tripName;

    @Column(nullable = false)
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;


    @ManyToMany
    @JoinTable(
            name = "trip_city",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private List<City> cities;

    @ManyToMany
    @JoinTable(
            name = "trip_activity",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDescription() {
        return (description != null) ? description : "No description provided";
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
