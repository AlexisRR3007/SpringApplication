package com.emse.spring.faircorp.api.heater;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

/**
 * HeaterCommand is a simplified HeaterDto which is used when a user
 * need to create a heater. He does not have to give a full room, just the ID
 */
public class HeaterCommand {
    private Long id;
    private String name;
    private HeaterStatus heaterStatus;
    private Long roomId;

    public HeaterCommand() {
    }

    public HeaterCommand(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.heaterStatus = heater.getHeaterStatus();
        this.roomId = heater.getRoom().getId();
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

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
