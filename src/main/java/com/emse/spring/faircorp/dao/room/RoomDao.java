package com.emse.spring.faircorp.dao.room;

import com.emse.spring.faircorp.dao.room.RoomDaoCustom;
import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {

    @Query("select r from Room r where r.id = ?1")
    Room getRoom(Long id);
}
