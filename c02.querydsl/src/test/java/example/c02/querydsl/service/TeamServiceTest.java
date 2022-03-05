package example.c02.querydsl.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {

    @Resource TeamService svc;

    @Test
    void doSomething() {
        long teamId = svc.saveTeamAndReturnTeamId();
        var members = svc.getMembers(teamId);

        assertThat(members.isEmpty(), not(true));
    }
}