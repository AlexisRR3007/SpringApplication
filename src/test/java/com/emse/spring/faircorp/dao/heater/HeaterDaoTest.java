package com.emse.spring.faircorp.dao.heater;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * Test of the HeaterDao
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {

    @Autowired
    private HeaterDao heaterDao;

    @Test
    public void shouldFindAHeater() {
        Heater heater = heaterDao.getHeater(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater21");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
    }

    @Test
    public void shouldFindAllHeatersOfRoom() {
        List<Heater> result = heaterDao.getAllHeatersOfRoom(-2L);
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void shouldFindAllOnHeatersOfRoom() {
        List<Heater> result = heaterDao.getOnHeatersOfRoom(-2L);
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void shouldFindAllOffHeatersOfRoom() {
        List<Heater> result = heaterDao.getOffHeatersOfRoom(-2L);
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void shouldDeleteAllHeatersOfRoom() {
        heaterDao.deleteAllHeatersOfRoom(-2L);
        List<Heater> result = heaterDao.getAllHeatersOfRoom(-2L);
        Assertions.assertThat(result).isEmpty();
    }

}
