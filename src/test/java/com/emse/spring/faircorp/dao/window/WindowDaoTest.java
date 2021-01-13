package com.emse.spring.faircorp.dao.window;

import com.emse.spring.faircorp.dao.heater.HeaterDao;
import com.emse.spring.faircorp.dao.window.WindowDao;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WindowDaoTest {
    @Autowired
    private WindowDao windowDao;

    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getWindow(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window21");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.OPEN);
    }

    @Test
    public void shouldFindAllWindowsOfRoom() {
        List<Window> result = windowDao.getAllWindowsOfRoom(-2L);
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void shouldFindAllOnWindowsOfRoom() {
        List<Window> result = windowDao.getOpenWindowsOfRoom(-2L);
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void shouldFindAllOffWindowsOfRoom() {
        List<Window> result = windowDao.getClosedWindowsOfRoom(-2L);
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void shouldDeleteAllWindowsOfRoom() {
        windowDao.deleteAllWindowsOfRoom(-2L);
        List<Window> result = windowDao.getAllWindowsOfRoom(-2L);
        Assertions.assertThat(result).isEmpty();
    }
}
