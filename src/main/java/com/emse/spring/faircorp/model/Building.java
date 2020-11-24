package com.emse.spring.faircorp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BUILDING")
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "")
    private Set<Room> listOfRoom;

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

    public Set<Room> getListOfRoom() {
        return listOfRoom;
    }

    public void setListOfRoom(Set<Room> listOfRoom) {
        this.listOfRoom = listOfRoom;
    }
}
