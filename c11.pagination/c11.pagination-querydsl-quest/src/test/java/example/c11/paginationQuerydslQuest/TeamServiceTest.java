package example.c11.paginationQuerydslQuest;

import example.c11.paginationQuerydslQuest.service.TeamService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Disabled("fix this test")
@SpringBootTest(classes = TestConfig.class)
class TeamServiceTest {
    @Resource
    TeamService svc;

    @Test
    void setUp_get() {
        svc.setUp();
        svc.getPagedTeams(0, 5);
    }
}