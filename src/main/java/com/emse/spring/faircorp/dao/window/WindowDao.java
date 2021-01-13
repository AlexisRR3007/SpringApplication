package com.emse.spring.faircorp.dao.window;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Dao for the windows
 */
public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {

    @Query("select w from Window w where w.id = ?1")
    Window getWindow(Long id);

    @Modifying
    @Query("DELETE FROM Window w WHERE w.room.id = ?1")
    void deleteAllWindowsOfRoom(Long RoomId);

}