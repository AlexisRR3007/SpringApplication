package com.emse.spring.faircorp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Room entity which represent a room in the floor.
 * Contain a link to the floor and a list of the heaters and
 * the windows of the room
 */
@Entity
@Table(name = "TROOM")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Floor floor;

    @Column(nullable=false)
    private String name;

    @Column
    private Double currentTemperature;

    @Column
    private Double targetTemperature;

    @JsonBackReference
    @OneToMany(mappedBy = "room")
    private Set<Heater> listOfHeaters;

    @JsonBackReference
    @OneToMany(mappedBy = "room")
    private Set<Window> listOfWindows;

    public Room() {
    }

    public Room(Floor floor, String name) {
        this.floor = floor;
        this.name = name;
    }

    public Room(Floor floor, String name, Double currentTemperature, Double targetTemperature) {
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Set<Heater> getListOfHeaters() {
        return listOfHeaters;
    }

    public void setListOfHeaters(Set<Heater> listOfHeaters) {
        this.listOfHeaters = listOfHeaters;
    }

    public Set<Window> getListOfWindows() {
        return listOfWindows;
    }

    public void setListOfWindows(Set<Window> listOfWindows) {
        this.listOfWindows = listOfWindows;
    }
}
