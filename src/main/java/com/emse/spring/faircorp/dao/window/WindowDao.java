package com.emse.spring.faircorp.dao.window;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {

    @Query("select w from Window w where w.id = ?1")
    Window getWindow(Long id);

    @Query("Select w FROM Window w WHERE w.room.floor.id = ?1")
    List<Window> getAllWindowsOfFloor(Long FloorId);

    @Query("Select w FROM Window w WHERE w.room.floor.building.id = ?1")
    List<Window> getAllWindowsOfBuilding(Long BuildingId);

    @Query("select w from Window w where w.room.floor.id = ?1 and w.windowStatus = 'OPEN'")
    List<Window> getOpenWindowsOfFloor(Long FloorId);

    @Query("select w from Window w where w.room.floor.id = ?1 and w.windowStatus = 'CLOSED'")
    List<Window> getClosedWindowsOfFloor(Long FloorId);

    @Query("select w from Window w where w.room.floor.building.id = ?1 and w.windowStatus = 'OPEN'")
    List<Window> getOpenWindowsOfBuilding(Long BuildingId);

    @Query("select w from Window w where w.room.floor.building.id = ?1 and w.windowStatus = 'CLOSED'")
    List<Window> getClosedWindowsOfBuilding(Long BuildingId);
    
    @Modifying
    @Query("DELETE FROM Window w WHERE w.room.id = ?1")
    void deleteAllWindowsOfRoom(Long RoomId);

    @Modifying
    @Query("DELETE FROM Window w WHERE w.room.floor.id = ?1")
    void deleteAllWindowsOfFloor(Long FloorId);

    @Modifying
    @Query("DELETE FROM Window w WHERE w.room.floor.building.id = ?1")
    void deleteAllWindowsOfBuilding(Long BuildingId);

}