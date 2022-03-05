package c06.mapsId.service;

import c06.mapsId.entity.Team;
import c06.mapsId.entity.TeamDetail;
import c06.mapsId.repo.TeamRepo;
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

        var detail0 = new TeamDetail();
        detail0.setPk(new TeamDetail.Pk("t1"));
        detail0.setDesc("desc1");
        detail0.setTeam(team);

        var detail1 = new TeamDetail();
        detail1.setPk(new TeamDetail.Pk("t2"));
        detail1.setDesc("desc2");
        detail1.setTeam(team);

        team.getDetails().add(detail0);
        team.getDetails().add(detail1);

        teamRepo.save(team);
    }
}
