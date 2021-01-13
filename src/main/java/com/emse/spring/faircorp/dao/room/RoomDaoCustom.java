package com.emse.spring.faircorp.dao.room;


import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> getRoomByName(String name);
}
