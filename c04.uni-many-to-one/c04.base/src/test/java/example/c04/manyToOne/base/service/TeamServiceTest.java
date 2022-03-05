package example.c04.manyToOne.base.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TeamServiceTest {

    @Resource TeamService svc;

    @Test
    void doSomething() {
        svc.doSomething();
    }
}