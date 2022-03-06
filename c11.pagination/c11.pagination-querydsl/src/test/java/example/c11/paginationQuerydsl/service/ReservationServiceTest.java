package example.c11.paginationQuerydsl.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = TestConfig.class)
class ReservationServiceTest {
    @Resource ReservationService svc;

    @Test
    void setUp_getOne() {
        svc.setUp();
        var one = svc.getPagedSeats(0, 10);
        assertFalse(one.isEmpty());
    }
}