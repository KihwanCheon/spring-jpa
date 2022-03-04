package example.c03.solution.service;

import example.c03.solution.entity.Team;
import example.c03.solution.entity.TeamDetail;
import example.c03.solution.repo.TeamDetailRepo;
import example.c03.solution.repo.TeamRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.springframework.test.util.ReflectionTestUtils.*;

@Slf4j
@Service
public class TeamService {
    final TeamRepo teamRepo;
    final TeamDetailRepo teamDetailRepo;

    public TeamService(TeamRepo teamRepo, TeamDetailRepo teamDetailRepo) {
        this.teamRepo = teamRepo;
        this.teamDetailRepo = teamDetailRepo;
    }

    @Transactional
    public void doSomeThing() {
        var team = new Team();
        invokeSetterMethod(team, "name", "team1");
        invokeSetterMethod(team, "createDate", LocalDateTime.now());

        var savedTeam = teamRepo.save(team);
        Assert.notNull(savedTeam, "savedTeam must be not null");

        var dbTeam = teamRepo.findById((Long) invokeGetterMethod(savedTeam, "id"));
        Assert.isTrue(dbTeam.isPresent(), "dbTeam must be present");

        var detail = new TeamDetail();
        invokeSetterMethod(detail, "team", team);
        invokeSetterMethod(detail, "type", "t1");
        invokeSetterMethod(detail, "desc", "team-desc1");

        var savedDetail = teamDetailRepo.save(detail);
        Assert.notNull(savedDetail, "savedDetail must be not null");
        var dbDetail = teamDetailRepo.findById((Long) invokeGetterMethod(savedDetail, "id"));
        Assert.isTrue(dbDetail.isPresent(), "dbDetail must be present");
    }
}
