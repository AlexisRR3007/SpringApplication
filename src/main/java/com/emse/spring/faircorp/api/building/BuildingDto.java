package com.emse.spring.faircorp.api.building;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Floor;

import java.util.Set;

/**
 * BuildingDto which carries between processes
 */
public class BuildingDto {

    private Long id;
    private String name;
    private Set<Floor> listOfFloors;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.listOfFloors = building.getListOfFloors();
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

    public Set<Floor> getListOfFloors() {
        return listOfFloors;
    }

    public void setListOfFloors(Set<Floor> listOfFloors) {
        this.listOfFloors = listOfFloors;
    }

}
