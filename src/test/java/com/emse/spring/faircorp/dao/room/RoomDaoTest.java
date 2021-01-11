package com.emse.spring.faircorp.dao.room;

import com.emse.spring.faircorp.dao.room.RoomDao;
import com.emse.spring.faircorp.model.Room;
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
class RoomDaoTest {
    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getOne(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getCurrentTemperature()).isEqualTo(22.3);
    }

    @Test
    public void shouldFindARoomByName() {
        List<Room> result = roomDao.getRoomByName("Room1");
        Assertions.assertThat(result).hasSize(1)
                .extracting("id", "floor")
                .containsExactly(Tuple.tuple(-10L, 1));
    }
}
