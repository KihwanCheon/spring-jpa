package example.c09.methodNamingSovled.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {
    @Resource
    TeamService svc;

    @Test
    void doSomething() {
        svc.setUp();
        svc.getTeamDescriptionsByType();
    }
}