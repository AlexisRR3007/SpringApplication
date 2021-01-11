package com.emse.spring.faircorp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Building entity, it contains all the other entities.
 * It is link to the floors of the buildings
 */
@Entity
@Table(name = "TBUILDING")
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "building")
    private Set<Floor> listOfFloors;

    public Building() {
    }

    public Building(String name) {
        this.name = name;
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
