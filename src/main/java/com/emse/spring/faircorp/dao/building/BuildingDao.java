package com.emse.spring.faircorp.dao.building;

import com.emse.spring.faircorp.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Dao for the buildings
 */
public interface BuildingDao extends JpaRepository<Building, Long> {
}
