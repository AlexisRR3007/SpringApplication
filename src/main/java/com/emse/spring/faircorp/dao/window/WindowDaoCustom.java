package com.emse.spring.faircorp.dao.window;

import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface WindowDaoCustom {

    List<Window> getOpenWindowsOfRoom(Long id);

    List<Window> getClosedWindowsOfRoom(Long id);

    List<Window> getAllWindowsOfRoom(Long RoomId);

}
