package com.emse.spring.faircorp.dao.room;


import com.emse.spring.faircorp.model.Room;

import java.util.List;

/**
 * Interface which defines the method of our customDao for rooms
 */
public interface RoomDaoCustom {

    List<Room> getRoomByName(String name);

}
