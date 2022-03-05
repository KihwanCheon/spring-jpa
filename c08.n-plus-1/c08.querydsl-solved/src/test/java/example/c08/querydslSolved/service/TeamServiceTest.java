package example.c08.querydslSolved.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {
    @Resource
    TeamService svc;

    @Test
    void setUp_get() {
        svc.setUp();
        var desc0 = svc.getAllTeamDesc();
        assertThat(desc0.size(), greaterThan(0));

        var desc1 = svc.getAllTeamDescWithFindAll();
        assertThat(desc1.size(), greaterThan(0));

    }
}