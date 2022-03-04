package example.c04.cascade.service;

import example.c04.cascade.entity.Team;
import example.c04.cascade.entity.TeamDetail;
import example.c04.cascade.repo.TeamDetailRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Service
public class TeamService {

    final TeamDetailRepo teamDetailRepo;

    public TeamService(TeamDetailRepo teamDetailRepo) {
        this.teamDetailRepo = teamDetailRepo;
    }

    @Transactional
    public void doSomething() {
        var team = new Team();
        team.setName("team1");
        team.setCreateDate(LocalDateTime.now());

        var detail0 = new TeamDetail();
        detail0.setTeam(team);
        detail0.setType("t1");
        detail0.setDesc("desc1");

        var detail1 = new TeamDetail();
        detail1.setTeam(team);
        detail1.setType("t1");
        detail1.setDesc("desc1");

        teamDetailRepo.saveAll(Arrays.asList(detail0, detail1));
    }
}
