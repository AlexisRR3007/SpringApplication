package com.emse.spring.faircorp.api.room;

import com.emse.spring.faircorp.model.Room;

/**
 * RoomCommand is a simplified RoomDto which is used when a user
 * need to create a room. He does not have to give a full floor, just the ID
 * He does not give windows and heaters
 */
public class RoomCommand {

    private Long id;
    private String name;
    private Long floorId;
    private Double currentTemperature;
    private Double targetTemperature;

    public RoomCommand() {
    }

    public RoomCommand(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floorId = room.getFloor().getId();
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

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
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
