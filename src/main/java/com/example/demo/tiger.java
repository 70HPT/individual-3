package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "Tigers")
public class tiger {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long tigerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String subspecies;
    private String habitatRegion;

    public tiger() {

    }

    public tiger(Long tigerId, String name, String description, String subspecies, String habitatRegion) {
        this.tigerId = tigerId;
        this.name = name;
        this.description = description;
        this.subspecies = subspecies;
        this.habitatRegion = habitatRegion;
    }

    // Constructor without ID
    public tiger(String name, String description, String subspecies, String habitatRegion) {
        this.name = name;
        this.description = description;
        this.subspecies = subspecies;
        this.habitatRegion = habitatRegion;
    }

    // Getters and Setters
    public Long getTigerId() {
        return tigerId;
    }

    public void setTigerId(Long tigerId) {
        this.tigerId = tigerId;
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

    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    public String getHabitatRegion() {
        return habitatRegion;
    }

    public void setHabitatRegion(String habitatRegion) {
        this.habitatRegion = habitatRegion;
    }



}
