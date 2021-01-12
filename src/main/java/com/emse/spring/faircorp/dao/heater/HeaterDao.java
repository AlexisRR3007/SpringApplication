package com.emse.spring.faircorp.dao.heater;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeaterDao extends JpaRepository<Heater, Long> {

    @Query("Select h from Heater h where h.id = ?1")
    Heater getHeater(Long id);

    @Query("Select h FROM Heater h WHERE h.room.id = ?1")
    List<Heater> getAllHeatersOfRoom(Long RoomId);

    @Query("Select h FROM Heater h WHERE h.room.floor.id = ?1")
    List<Heater> getAllHeatersOfFloor(Long FloorId);

    @Query("Select h FROM Heater h WHERE h.room.floor.building.id = ?1")
    List<Heater> getAllHeatersOfBuilding(Long BuildingId);

    @Query("select h from Heater h where h.room.id = ?1 and h.heaterStatus = 'ON'")
    List<Heater> getOnHeatersOfRoom(Long RoomId);

    @Query("select h from Heater h where h.room.id = ?1 and h.heaterStatus = 'OFF'")
    List<Heater> getOffHeatersOfRoom(Long RoomId);

    @Query("select h from Heater h where h.room.floor.id = ?1 and h.heaterStatus = 'ON'")
    List<Heater> getOnHeatersOfFloor(Long FloorId);

    @Query("select h from Heater h where h.room.floor.id = ?1 and h.heaterStatus = 'OFF'")
    List<Heater> getOffHeatersOfFloor(Long FloorId);

    @Query("select h from Heater h where h.room.floor.building.id = ?1 and h.heaterStatus = 'ON'")
    List<Heater> getOnHeatersOfBuilding(Long BuildingId);

    @Query("select h from Heater h where h.room.floor.building.id = ?1 and h.heaterStatus = 'OFF'")
    List<Heater> getOffHeatersOfBuilding(Long BuildingId);

    @Modifying
    @Query("DELETE FROM Heater h WHERE h.room.id = ?1")
    void deleteAllHeatersOfRoom(Long RoomId);

    @Modifying
    @Query("DELETE FROM Heater h WHERE h.room.floor.id = ?1")
    void deleteAllHeatersOfFloor(Long FloorId);

    @Modifying
    @Query("DELETE FROM Heater h WHERE h.room.floor.building.id = ?1")
    void deleteAllHeatersOfBuilding(Long BuildingId);
}
