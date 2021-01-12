package com.emse.spring.faircorp.api.building;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Floor;

import java.util.Set;

public class BuildingCommand {
    private Long id;
    private String name;

    public BuildingCommand() {
    }

    public BuildingCommand(Building building) {
        this.id = building.getId();
        this.name = building.getName();
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

}
