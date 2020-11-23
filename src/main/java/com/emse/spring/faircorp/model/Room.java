package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    private Long id;

    @Column(nullable=false)
    private int floor;

    @Column(nullable=false)
    private String name;

    @Column
    private Double currentTemperature;

    @Column
    private Double targetTemperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> listOfHeater;

    @OneToMany(mappedBy = "room")
    private Set<Window> listOfWindow;

    public Room() {
    }

    public Room(int floor, String name) {
        this.floor = floor;
        this.name = name;
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

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
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
