package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public RoomController(HeaterDao heaterDao, WindowDao windowDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomCommand dto) {

        Room room = null;
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getFloor(), dto.getName()));
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete (@PathVariable Long id){
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        Iterator iterator = room.getListOfHeater().iterator();
        while (iterator.hasNext())
        {
            heaterDao.deleteById(((Heater)iterator.next()).getId());
        }

        iterator = room.getListOfWindow().iterator();
        while (iterator.hasNext())
        {
            windowDao.deleteById(((Window)iterator.next()).getId());
        }
        roomDao.deleteById(room.getId());
    }
}
