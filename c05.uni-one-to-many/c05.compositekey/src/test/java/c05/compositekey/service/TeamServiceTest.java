package c05.compositekey.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {
    @Resource TeamService svc;

    @Test
    void doSomething() {
        svc.doSomething();
    }
}