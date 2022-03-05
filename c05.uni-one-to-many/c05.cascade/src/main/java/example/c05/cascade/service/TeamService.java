package example.c05.cascade.service;

import example.c05.cascade.entity.Team;
import example.c05.cascade.entity.TeamDetail;
import example.c05.cascade.repo.TeamRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j
@Service
public class TeamService {

    final TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    @Transactional
    public void doSomething() {
        var detail0 = new TeamDetail();
        detail0.setType("t1");
        detail0.setDesc("desc1");

        var detail1 = new TeamDetail();
        detail1.setType("t1");
        detail1.setDesc("desc1");

        var team = new Team();
        team.setName("team1");
        team.setCreateDate(LocalDateTime.now());

        team.getDetails().add(detail0);
        team.getDetails().add(detail1);
        teamRepo.save(team);
    }
}
