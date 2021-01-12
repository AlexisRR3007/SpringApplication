package com.emse.spring.faircorp.api.floor;

import com.emse.spring.faircorp.dao.building.BuildingDao;
import com.emse.spring.faircorp.dao.floor.FloorDao;
import com.emse.spring.faircorp.dao.heater.HeaterDao;
import com.emse.spring.faircorp.dao.room.RoomDao;
import com.emse.spring.faircorp.dao.window.WindowDao;
import com.emse.spring.faircorp.model.Building;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

//    @GetMapping(path = "/{id}")
//    public FloorDto findById(@PathVariable Long id) {
//        return buildingDao.findById(id).map(FloorDto::new).orElse(null);
//    }
//
//    @PostMapping
//    public FloorDto create(@RequestBody FloorCommand cmd) {
//
//        Building building = null;
//        if (cmd.getId() == null) {
//            building = buildingDao.save(new Building(cmd.getName()));
//        }
//        return new FloorDto(building);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    public void delete (@PathVariable Long id){
//        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        heaterDao.deleteAllHeatersOfBuilding(id);
//
//        windowDao.deleteAllWindowsOfBuilding(id);
//
//        buildingDao.deleteById(id);
//    }
//
//    @PutMapping(path = "/{id}/switchWindow")
//    public FloorDto switchStatusOfWindow(@PathVariable Long id) {
//        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        List<Window> windowSet = windowDao.getAllWindowsOfBuilding(id);
//
//        windowSet.forEach((temp) -> {
//            temp.setWindowStatus(temp.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
//        });
//
//        return new FloorDto(building);
//    }
//
//    @PutMapping(path = "/{id}/switchHeater")
//    public FloorDto switchStatusOfHeater(@PathVariable Long id) {
//        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        List<Heater> heaterSet = heaterDao.getAllHeatersOfBuilding(id);
//
//        heaterSet.forEach((temp) -> {
//            temp.setHeaterStatus(temp.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
//        });
//
//        return new FloorDto(building);
//    }
//
//    @PutMapping(path = "/{id}/closeAllWindows")
//    public FloorDto closeWindows(@PathVariable Long id) {
//        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        List<Window> windowSet = windowDao.getAllWindowsOfBuilding(id);
//
//        windowSet.forEach((temp) -> {
//            temp.setWindowStatus(WindowStatus.CLOSED);
//        });
//
//        return new FloorDto(building);
//    }
//
//    @PutMapping(path = "/{id}/openAllWindows")
//    public FloorDto openWindows(@PathVariable Long id) {
//        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        List<Window> windowSet = windowDao.getAllWindowsOfBuilding(id);
//
//        windowSet.forEach((temp) -> {
//            temp.setWindowStatus(WindowStatus.OPEN);
//        });
//
//        return new FloorDto(building);
//    }
//
//    @PutMapping(path = "/{id}/offAllHeaters")
//    public FloorDto offHeaters(@PathVariable Long id) {
//        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        List<Heater> heaterSet = heaterDao.getAllHeatersOfBuilding(id);
//
//        heaterSet.forEach((temp) -> {
//            temp.setHeaterStatus(HeaterStatus.OFF);
//        });
//
//        return new FloorDto(building);
//    }
//
//    @PutMapping(path = "/{id}/onAllHeaters")
//    public FloorDto onHeaters(@PathVariable Long id) {
//        Building building = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        List<Heater> heaterSet = heaterDao.getAllHeatersOfBuilding(id);
//
//        heaterSet.forEach((temp) -> {
//            temp.setHeaterStatus(HeaterStatus.ON);
//        });
//
//        return new FloorDto(building);
//    }
}
