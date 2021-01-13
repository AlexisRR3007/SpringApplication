package com.emse.spring.faircorp.dao.room;

import com.emse.spring.faircorp.dao.heater.HeaterDao;
import com.emse.spring.faircorp.dao.window.WindowDao;
import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * Test of the RoomDao
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private HeaterDao heaterDao;
    @Autowired
    private WindowDao windowDao;

    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getRoom(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room11");
        Assertions.assertThat(room.getCurrentTemperature()).isEqualTo(20.3);
    }

    @Test
    public void shouldFindARoomByName() {
        List<Room> result = roomDao.getRoomByName("Room1");
        Assertions.assertThat(result).hasSize(1)
                .extracting("id", "floor.id")
                .containsExactly(Tuple.tuple(-20L, -9L));
    }

    @Test
    public void shouldFindAllOffRoomsOfFloor() {
        List<Room> result = roomDao.getAllRoomsOfFloor(-10L);
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void shouldDeleteAllRoomsOfFloor() {
        // Floor -10
        heaterDao.deleteAllHeatersOfRoom(-1L);
        heaterDao.deleteAllHeatersOfRoom(-2L);
        heaterDao.deleteAllHeatersOfRoom(-14L);
        windowDao.deleteAllWindowsOfRoom(-1L);
        windowDao.deleteAllWindowsOfRoom(-2L);
        windowDao.deleteAllWindowsOfRoom(-14L);

        roomDao.deleteAllRoomsOfFloor(-10L);
        List<Room> result = roomDao.getAllRoomsOfFloor(-10L);
        Assertions.assertThat(result).isEmpty();
    }

}
