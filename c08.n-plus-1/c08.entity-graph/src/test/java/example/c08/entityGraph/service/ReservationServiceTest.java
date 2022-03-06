package example.c08.entityGraph.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestConfig.class)
class ReservationServiceTest {
    @Resource ReservationService svc;

    @Test
    void setUp_getOne() {
        svc.setUp();
        var one = svc.getOne();
        assertTrue(one.isPresent());
    }
}