package com.emse.spring.faircorp.api.building;

import com.emse.spring.faircorp.model.Building;

/**
 * BuildingCommand is a simplified BuildingDto which is used when a user
 * need to create a building. He does not have to give floors
 */
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
