package example.c10.multibagQuerydsl.service;

import example.c10.multibagQuerydslQuest.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = TestConfig.class)
class ReservationServiceTest {
    @Resource
    ReservationService svc;

    @Test
    void setUp_getOne() {
        svc.setUp();
        assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            var one = svc.getMultiWithReservedSeats();
            assertFalse(one.isEmpty());
        });
    }
}