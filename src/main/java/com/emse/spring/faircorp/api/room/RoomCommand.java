package com.emse.spring.faircorp.api.room;

import com.emse.spring.faircorp.model.Room;

public class RoomCommand {
    private Long id;
    private String name;
    private int floorNumber;
    private Double currentTemperature;
    private Double targetTemperature;

    public RoomCommand() {
    }

    public RoomCommand(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floorNumber = room.getFloor().getFloorNumber();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
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

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
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
}
