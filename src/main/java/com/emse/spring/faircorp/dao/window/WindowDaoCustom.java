package com.emse.spring.faircorp.dao.window;

import com.emse.spring.faircorp.model.Window;

import java.util.List;

/**
 * Interface which defines the method of our customDao for windows
 */
public interface WindowDaoCustom {

    List<Window> getOpenWindowsOfRoom(Long id);

    List<Window> getClosedWindowsOfRoom(Long id);

    List<Window> getAllWindowsOfRoom(Long RoomId);

}
