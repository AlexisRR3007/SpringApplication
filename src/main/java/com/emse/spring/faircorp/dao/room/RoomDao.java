package com.emse.spring.faircorp.dao.room;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Dao for the rooms
 */
public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {

    @Query("select r from Room r where r.id = ?1")
    Room getRoom(Long id);

    @Query("Select r FROM Room r WHERE r.floor.id = ?1")
    List<Room> getAllRoomsOfFloor(Long FloorId);

    @Modifying
    @Query("DELETE FROM Room r WHERE r.floor.id = ?1")
    void deleteAllRoomsOfFloor(Long FloorId);

}
