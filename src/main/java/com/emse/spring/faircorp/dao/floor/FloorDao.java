package com.emse.spring.faircorp.dao.floor;

import com.emse.spring.faircorp.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Dao for the floors
 */
public interface FloorDao extends JpaRepository<Floor, Long> {

    @Query("Select f FROM Floor f WHERE f.floorNumber = ?1")
    List<Floor> getFloorByFloorNumber(int FloorNumber);

    @Query("Select f FROM Floor f WHERE f.building.id = ?1")
    List<Floor> getAllFloorsOfBuilding(Long BuildingId);

    @Modifying
    @Query("DELETE FROM Floor f WHERE f.building.id = ?1")
    void deleteAllFloorsOfBuilding(Long BuildingId);

}
