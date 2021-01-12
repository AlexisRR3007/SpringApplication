package com.emse.spring.faircorp.api.room;

import com.emse.spring.faircorp.api.heater.HeaterDto;
import com.emse.spring.faircorp.api.window.WindowDto;
import com.emse.spring.faircorp.dao.floor.FloorDao;
import com.emse.spring.faircorp.dao.heater.HeaterDao;
import com.emse.spring.faircorp.dao.room.RoomDao;
import com.emse.spring.faircorp.dao.window.WindowDao;

import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final FloorDao floorDao;

    public RoomController(HeaterDao heaterDao, WindowDao windowDao, RoomDao roomDao, FloorDao floorDao) {
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.roomDao = roomDao;
        this.floorDao = floorDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @GetMapping(path = "/{id}/heatersOn")
    public List<HeaterDto> findHeatersOn(@PathVariable Long id) {
        return heaterDao.getOnHeatersOfRoom(id).stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}/heatersOff")
    public List<HeaterDto> findHeatersOff(@PathVariable Long id) {
        return heaterDao.getOffHeatersOfRoom(id).stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}/windowsOpen")
    public List<WindowDto> findWindowsOn(@PathVariable Long id) {
        return windowDao.getOpenWindowsOfRoom(id).stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}/windowsClosed")
    public List<WindowDto> findWindowsOff(@PathVariable Long id) {
        return windowDao.getClosedWindowsOfRoom(id).stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomCommand cmd) {

        Floor floor = floorDao.findById(cmd.getFloorId()).orElseThrow(IllegalArgumentException::new);
        Room room = null;
        if (cmd.getId() == null) {
            room = roomDao.save(new Room(floor, cmd.getName(), cmd.getCurrentTemperature(), cmd.getTargetTemperature()));
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete (@PathVariable Long id){
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        heaterDao.deleteAllHeatersOfRoom(id);

        windowDao.deleteAllWindowsOfRoom(id);

        roomDao.deleteById(id);
    }

    @PutMapping(path = "/{id}/switchWindow")
    public RoomDto switchStatusOfWindow(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        List<Window> windowSet = windowDao.getAllWindowsOfRoom(id);

        windowSet.forEach((temp) -> {
            temp.setWindowStatus(temp.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        });

        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/switchHeater")
    public RoomDto switchStatusOfHeater(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        List<Heater> heaterSet = heaterDao.getAllHeatersOfRoom(id);

        heaterSet.forEach((temp) -> {
            temp.setHeaterStatus(temp.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        });

        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/closeAllWindows")
    public RoomDto closeWindows(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        List<Window> windowSet = windowDao.getAllWindowsOfRoom(id);

        windowSet.forEach((temp) -> {
            temp.setWindowStatus(WindowStatus.CLOSED);
        });

        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/openAllWindows")
    public RoomDto openWindows(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        List<Window> windowSet = windowDao.getAllWindowsOfRoom(id);

        windowSet.forEach((temp) -> {
            temp.setWindowStatus(WindowStatus.OPEN);
        });

        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/offAllHeaters")
    public RoomDto offHeaters(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        List<Heater> heaterSet = heaterDao.getAllHeatersOfRoom(id);

        heaterSet.forEach((temp) -> {
            temp.setHeaterStatus(HeaterStatus.OFF);
        });

        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/onAllHeaters")
    public RoomDto onHeaters(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        List<Heater> heaterSet = heaterDao.getAllHeatersOfRoom(id);

        heaterSet.forEach((temp) -> {
            temp.setHeaterStatus(HeaterStatus.ON);
        });

        return new RoomDto(room);
    }
}
