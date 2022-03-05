package c05.cascade.service;

import c05.cascade.C05CascadeApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import javax.annotation.Resource;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "c05")
@EntityScan(basePackages = "c05")
@ComponentScan(excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = C05CascadeApp.class)})
class TestConfig {
}

@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {
    @Resource TeamService svc;

    @Test
    void doSomething() {
        svc.doSomething();
    }
}