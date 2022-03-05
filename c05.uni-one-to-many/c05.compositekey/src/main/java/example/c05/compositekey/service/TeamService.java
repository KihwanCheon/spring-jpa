package example.c05.compositekey.service;

import example.c05.compositekey.entity.Team;
import example.c05.compositekey.entity.TeamDetail;
import example.c05.compositekey.repo.TeamRepo;
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
        var team = new Team();
        team.setName("team1");
        team.setCreateDate(LocalDateTime.now());
        var savedTeam = teamRepo.save(team);

        var detail0 = new TeamDetail();
        detail0.setPk(new TeamDetail.Pk(savedTeam.getId(), "t1"));
        detail0.setDesc("desc1");

        var detail1 = new TeamDetail();
        detail1.setPk(new TeamDetail.Pk(savedTeam.getId(), "t2"));
        detail1.setDesc("desc2");

        team.getDetails().add(detail0);
        team.getDetails().add(detail1);
    }
}
