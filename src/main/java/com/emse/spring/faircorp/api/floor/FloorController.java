package com.emse.spring.faircorp.api.floor;

import com.emse.spring.faircorp.dao.building.BuildingDao;
import com.emse.spring.faircorp.dao.floor.FloorDao;
import com.emse.spring.faircorp.dao.heater.HeaterDao;
import com.emse.spring.faircorp.dao.room.RoomDao;
import com.emse.spring.faircorp.dao.window.WindowDao;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Floor;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RestController for the floor
 */
@RestController
@CrossOrigin
@RequestMapping("/api/floors")
@Transactional
public class FloorController {

    private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final FloorDao floorDao;
    private final BuildingDao buildingDao;

    public FloorController(HeaterDao heaterDao, WindowDao windowDao, RoomDao roomDao, FloorDao floorDao, BuildingDao buildingDao) {
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.roomDao = roomDao;
        this.floorDao = floorDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<FloorDto> findAll() {
        return floorDao.findAll().stream().map(FloorDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public FloorDto findById(@PathVariable Long id) {
        return floorDao.findById(id).map(FloorDto::new).orElse(null);
    }

    @PostMapping
    public FloorDto create(@RequestBody FloorCommand cmd) {

        Building building = buildingDao.findById(cmd.getBuildingId()).orElseThrow(IllegalArgumentException::new);
        Floor floor = null;
        if (cmd.getId() == null) {
            floor = floorDao.save(new Floor(cmd.getFloorNumber(), cmd.getTargetTemperature(), building));
        }
        return new FloorDto(floor);

    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {

        List<Room> roomList = roomDao.getAllRoomsOfFloor(id);
        Iterator roomIterator = roomList.iterator();

        while (roomIterator.hasNext()) {
            Room room = (Room) roomIterator.next();
            heaterDao.deleteAllHeatersOfRoom(room.getId());
            windowDao.deleteAllWindowsOfRoom(room.getId());
        }

        roomDao.deleteAllRoomsOfFloor(id);

        floorDao.deleteById(id);

    }

}
