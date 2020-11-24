package com.emse.spring.faircorp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private int floor;

    @Column(nullable=false)
    private String name;

    @Column
    private Double currentTemperature;

    @Column
    private Double targetTemperature;

    @JsonBackReference
    @OneToMany(mappedBy = "room")
    private Set<Heater> listOfHeater;

    @JsonBackReference
    @OneToMany(mappedBy = "room")
    private Set<Window> listOfWindow;

    // @JsonManagedReference
    // @ManyToOne(optional = false)
    // private Building building;

    public Room() {
    }

    public Room(int floor, String name) {
        this.floor = floor;
        this.name = name;
    }

    public Room(int floor, String name, Double currentTemperature, Double targetTemperature) {
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
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

    public Set<Heater> getListOfHeater() {
        return listOfHeater;
    }

    public void setListOfHeater(Set<Heater> listOfHeater) {
        this.listOfHeater = listOfHeater;
    }

    public Set<Window> getListOfWindow() {
        return listOfWindow;
    }

    public void setListOfWindow(Set<Window> listOfWindow) {
        this.listOfWindow = listOfWindow;
    }
}