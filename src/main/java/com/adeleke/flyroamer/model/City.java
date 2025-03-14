package com.adeleke.flyroamer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "cities")
@Data  // Lombok annotation to generate getters, setters, toString, etc.
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activity> activities;

    @ManyToMany
    @JoinTable(
            name = "trip_city",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id")
    )
    private List<Trip> trips;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
