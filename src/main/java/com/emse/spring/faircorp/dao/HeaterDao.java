package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeaterDao extends JpaRepository<Heater, Long> {

    @Query("select h from Heater h where h.id = ?1")
    Heater getOne(Long id);

    @Query("Select h FROM Heater h WHERE h.room.id = ?1")
    List<Heater> getAllHeatersFromARoomFromHeaterDao(Long RoomId);

    @Modifying
    @Query("DELETE FROM Heater h WHERE h.room.id = ?1")
    void deleteAllHeatersFromARoomFromHeaterDao(Long RoomId);
}
