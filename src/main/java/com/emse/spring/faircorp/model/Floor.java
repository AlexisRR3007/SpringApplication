package com.emse.spring.faircorp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity which represent a floor, it is link to one building
 * and to the rooms of the floor
 */
@Entity
@Table(name = "TFLOOR")
public class Floor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int floorNumber;

    @Column
    private Double targetTemperature;

    @JsonManagedReference
    @ManyToOne(optional = false)
    private Building building;

    @JsonBackReference
    @OneToMany(mappedBy = "floor")
    private Set<Room> listOfRooms;

    public Floor() {
    }

    public Floor(int floorNumber, Building building) {
        this.floorNumber = floorNumber;
        this.building = building;
    }

    public Floor(int floorNumber, Double targetTemperature, Building building) {
        this.floorNumber = floorNumber;
        this.targetTemperature = targetTemperature;
        this.building = building;
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
