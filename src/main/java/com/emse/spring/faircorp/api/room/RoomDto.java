package com.emse.spring.faircorp.api.room;

import com.emse.spring.faircorp.model.Floor;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.Set;

/**
 * RoomDto which carries between processes
 */
public class RoomDto {

    private Long id;
    private String name;
    private Floor floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private Set<Heater> listOfHeaters;
    private Set<Window> listOfWindows;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.listOfHeaters = room.getListOfHeaters();
        this.listOfWindows = room.getListOfWindows();
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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
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
