package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;

public class RoomDto {
    private Long id;
    private String name;
    private int floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private Set<Heater> listOfHeater;
    private Set<Window> listOfWindow;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.listOfHeater = room.getListOfHeater();
        this.listOfWindow = room.getListOfWindow();
    }

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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
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
