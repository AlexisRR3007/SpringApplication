package com.emse.spring.faircorp.dao.heater;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Dao for the heaters
 */
public interface HeaterDao extends JpaRepository<Heater, Long> {

    @Query("Select h from Heater h where h.id = ?1")
    Heater getHeater(Long id);

    @Query("Select h FROM Heater h WHERE h.room.id = ?1")
    List<Heater> getAllHeatersOfRoom(Long RoomId);

    @Query("select h from Heater h where h.room.id = ?1 and h.heaterStatus = 'ON'")
    List<Heater> getOnHeatersOfRoom(Long RoomId);

    @Query("select h from Heater h where h.room.id = ?1 and h.heaterStatus = 'OFF'")
    List<Heater> getOffHeatersOfRoom(Long RoomId);

    @Modifying
    @Query("DELETE FROM Heater h WHERE h.room.id = ?1")
    void deleteAllHeatersOfRoom(Long RoomId);

}
