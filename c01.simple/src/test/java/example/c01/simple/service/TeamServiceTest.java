package example.c01.simple.service;

import example.c01.simple.C01App;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {

    @Resource
    TeamService svc;

    @Test
    void doSomething() {
        long teamId = svc.saveTeamAndReturnTeamId();
        var members = svc.getMembers(teamId);

        assertThat(members.isEmpty(), not(true));
    }
}