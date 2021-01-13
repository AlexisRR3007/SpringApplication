package com.emse.spring.faircorp.api.building;

import com.emse.spring.faircorp.dao.room.RoomDao;
import com.emse.spring.faircorp.dao.floor.FloorDao;
import com.emse.spring.faircorp.dao.heater.HeaterDao;
import com.emse.spring.faircorp.dao.building.BuildingDao;
import com.emse.spring.faircorp.dao.window.WindowDao;

import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
    public void delete (@PathVariable Long id){
        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);

        heaterDao.deleteAllHeatersOfBuilding(id);

        windowDao.deleteAllWindowsOfBuilding(id);

        roomDao.deleteAllRoomsOfBuilding(id);

        floorDao.deleteAllFloorsOfBuilding(id);

        buildingDao.deleteById(id);
    }

}
