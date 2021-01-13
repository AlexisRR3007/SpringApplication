package com.emse.spring.faircorp.api.heater;

import com.emse.spring.faircorp.dao.heater.HeaterDao;
import com.emse.spring.faircorp.dao.room.RoomDao;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RestController for the heaters
 */
@RestController
@CrossOrigin
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }

    @PutMapping(path = "/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {

        Heater Heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        Heater.setHeaterStatus(Heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
        return new HeaterDto(Heater);

    }

    @PostMapping
    public HeaterDto create(@RequestBody HeaterCommand cmd) {

        // HeaterDto must always contain the heater room
        Room room = roomDao.findById(cmd.getRoomId()).orElseThrow(IllegalArgumentException::new);
        Heater heater = null;
        // On creation id is not defined
        if (cmd.getId() == null) {
            heater = heaterDao.save(new Heater(cmd.getName(), cmd.getHeaterStatus(), room));
        } else {
            heater = heaterDao.getHeater(cmd.getId());
            heater.setHeaterStatus(cmd.getHeaterStatus());
        }

        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}
