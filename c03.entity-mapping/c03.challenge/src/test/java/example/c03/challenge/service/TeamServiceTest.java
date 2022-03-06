package example.c03.challenge.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Disabled("fix this test")
@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {
    @Resource TeamService svc;

    @Test
    void doSomething() {
        svc.doSomeThing();
    }
}