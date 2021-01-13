package com.emse.spring.faircorp.api.building;

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
 * RestController for the buildings
 */
@RestController
@CrossOrigin
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {

    private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final FloorDao floorDao;
    private final BuildingDao buildingDao;

    public BuildingController(HeaterDao heaterDao, WindowDao windowDao, RoomDao roomDao, FloorDao floorDao, BuildingDao buildingDao) {
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.roomDao = roomDao;
        this.floorDao = floorDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null);
    }

    @PostMapping
    public BuildingDto create(@RequestBody BuildingCommand cmd) {

        Building building = null;
        if (cmd.getId() == null) {
            building = buildingDao.save(new Building(cmd.getName()));
        }
        return new BuildingDto(building);

    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {

        List<Floor> floorList = floorDao.getAllFloorsOfBuilding(id);
        Iterator floorIterator = floorList.iterator();

        while (floorIterator.hasNext()) {

            Floor floor = (Floor) floorIterator.next();
            List<Room> roomList = roomDao.getAllRoomsOfFloor(floor.getId());
            Iterator roomIterator = roomList.iterator();

            while (roomIterator.hasNext()) {
                Room room = (Room) roomIterator.next();
                heaterDao.deleteAllHeatersOfRoom(room.getId());
                windowDao.deleteAllWindowsOfRoom(room.getId());
            }

            roomDao.deleteAllRoomsOfFloor(floor.getId());

        }

        floorDao.deleteAllFloorsOfBuilding(id);

        buildingDao.deleteById(id);
    }

}
