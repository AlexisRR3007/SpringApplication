package com.emse.spring.faircorp.api.floor;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Floor;
import com.emse.spring.faircorp.model.Room;

import javax.persistence.*;
import java.util.Set;

public class FloorCommand {

    private Long id;
    private int floorNumber;
    private Double targetTemperature;
    private Long buildingId;

    public FloorCommand() {
    }

    public FloorCommand(Floor floor) {
        this.id = floor.getId();
        this.floorNumber = floor.getFloorNumber();
        this.targetTemperature = floor.getTargetTemperature();
        this.buildingId = floor.getBuilding().getId();
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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }
}
