package example.c07.quest.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = TestConfig.class)
class OrderServiceTest {
    @Resource OrderService svc;

    @Test
    void doSomething() {
        svc.doSomething();
    }
}