package example.c08.jpql.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReservationServiceTest {
    @Resource ReservationService svc;

    @Test
    void setUp_getOne() {
        svc.setUp();
        var one = svc.getOne();
        assertTrue(one.isPresent());
    }
}