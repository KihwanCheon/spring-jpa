package example.c05.base.service;

import example.c05.base.entity.Team;
import example.c05.base.entity.TeamDetail;
import example.c05.base.repo.TeamDetailRepo;
import example.c05.base.repo.TeamRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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
    public void doSomething() {
        var detail0 = new TeamDetail();
        detail0.setType("t1");
        detail0.setDesc("desc1");
        teamDetailRepo.save(detail0);

        var detail1 = new TeamDetail();
        detail1.setType("t1");
        detail1.setDesc("desc1");

        teamDetailRepo.save(detail1);

        var team = new Team();
        team.setName("team1");
        team.setCreateDate(LocalDateTime.now());

        team.getDetails().add(detail0);
        team.getDetails().add(detail1);
        teamRepo.save(team);
    }
}
