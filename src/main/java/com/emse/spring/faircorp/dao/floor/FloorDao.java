package com.emse.spring.faircorp.dao.floor;

import com.emse.spring.faircorp.model.Floor;
import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FloorDao  extends JpaRepository<Floor, Long> {

    @Query("Select f FROM Floor f WHERE f.floorNumber = ?1")
    Floor getFloorByFloorNumber(int FloorNumber);
}
