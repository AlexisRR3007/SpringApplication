package com.emse.spring.faircorp.api.floor;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Floor;
import com.emse.spring.faircorp.model.Room;

import javax.persistence.*;
import java.util.Set;

public class FloorDto {

    private Long id;
    private int floorNumber;
    private Double targetTemperature;
    private Building building;
    private Set<Room> listOfRooms;

    public FloorDto() {
    }

    public FloorDto(Floor floor) {
        this.id = floor.getId();
        this.floorNumber = floor.getFloorNumber();
        this.targetTemperature = floor.getTargetTemperature();
        this.building = floor.getBuilding();
        this.listOfRooms = floor.getListOfRooms();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<Room> getListOfRooms() {
        return listOfRooms;
    }

    public void setListOfRooms(Set<Room> listOfRooms) {
        this.listOfRooms = listOfRooms;
    }
}
