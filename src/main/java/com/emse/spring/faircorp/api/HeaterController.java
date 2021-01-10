package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {

    private final HeaterDao HeaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao HeaterDao, RoomDao roomDao) {
        this.HeaterDao = HeaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll() {
        return HeaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return HeaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }

    @PutMapping(path = "/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater Heater = HeaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        Heater.setHeaterStatus(Heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        return new HeaterDto(Heater);
    }

    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // HeaterDto must always contain the Heater room
        Room room = roomDao.getOne(dto.getRoomId());
        Heater Heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            Heater = HeaterDao.save(new Heater(dto.getName(), dto.getHeaterStatus(),room));
        }
        else {
            Heater = HeaterDao.getOne(dto.getId());
            Heater.setHeaterStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(Heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        HeaterDao.deleteById(id);
    }
}
