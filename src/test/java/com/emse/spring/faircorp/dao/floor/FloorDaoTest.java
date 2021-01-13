package com.emse.spring.faircorp.dao.floor;

import com.emse.spring.faircorp.dao.heater.HeaterDao;
import com.emse.spring.faircorp.dao.room.RoomDao;
import com.emse.spring.faircorp.dao.window.WindowDao;
import com.emse.spring.faircorp.model.Floor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * Test of the FloorDao
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class FloorDaoTest {

    @Autowired
    private FloorDao floorDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private WindowDao windowDao;
    @Autowired
    private HeaterDao heaterDao;

    @Test
    public void shouldFindAFloor() {
        Floor floor = floorDao.getOne(-10L);
        Assertions.assertThat(floor.getFloorNumber()).isEqualTo(1);
        Assertions.assertThat(floor.getBuilding().getId()).isEqualTo(-10L);
    }

    @Test
    public void shouldFindAFloorByFloorNumber() {
        List<Floor> result = floorDao.getFloorByFloorNumber(1);
        Assertions.assertThat(result).hasSize(3);
    }

    @Test
    public void shouldFindAllOffFloorsOfFloor() {
        List<Floor> result = floorDao.getAllFloorsOfBuilding(-10L);
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void shouldDeleteAllFloorsOfBuilding() {
        // Floor -10
        heaterDao.deleteAllHeatersOfRoom(-1L);
        heaterDao.deleteAllHeatersOfRoom(-2L);
        heaterDao.deleteAllHeatersOfRoom(-14L);
        windowDao.deleteAllWindowsOfRoom(-1L);
        windowDao.deleteAllWindowsOfRoom(-2L);
        windowDao.deleteAllWindowsOfRoom(-14L);

        // Floor -9
        heaterDao.deleteAllHeatersOfRoom(-3L);
        heaterDao.deleteAllHeatersOfRoom(-4L);
        heaterDao.deleteAllHeatersOfRoom(-15L);
        heaterDao.deleteAllHeatersOfRoom(-20L);
        windowDao.deleteAllWindowsOfRoom(-3L);
        windowDao.deleteAllWindowsOfRoom(-4L);
        windowDao.deleteAllWindowsOfRoom(-15L);
        windowDao.deleteAllWindowsOfRoom(-20L);

        // Floor -8
        heaterDao.deleteAllHeatersOfRoom(-5L);
        heaterDao.deleteAllHeatersOfRoom(-16L);
        windowDao.deleteAllWindowsOfRoom(-5L);
        windowDao.deleteAllWindowsOfRoom(-16L);

        // Rooms
        roomDao.deleteAllRoomsOfFloor(-10L);
        roomDao.deleteAllRoomsOfFloor(-9L);
        roomDao.deleteAllRoomsOfFloor(-8L);

        floorDao.deleteAllFloorsOfBuilding(-10L);
        List<Floor> result = floorDao.getAllFloorsOfBuilding(-10L);
        Assertions.assertThat(result).isEmpty();
    }

}
