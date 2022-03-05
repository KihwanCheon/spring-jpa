package example.c08.querydslquest.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {
    @Resource TeamService svc;

    @Disabled("fix this test")
    @Test
    void setUp_get() {
        svc.setUp();
        svc.getAllTeamDesc();
    }
}