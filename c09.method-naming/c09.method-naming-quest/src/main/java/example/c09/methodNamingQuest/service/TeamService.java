package example.c09.methodNamingQuest.service;

import example.c09.methodNamingQuest.entity.Team;
import example.c09.methodNamingQuest.entity.TeamDetail;
import example.c09.methodNamingQuest.repo.TeamRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TeamService {

    final TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    @Transactional
    public void setUp() {
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

    @Transactional(readOnly = true)
    public List<String> getTeamDescriptionsByType() {
        return teamRepo.changeMethodName("t1")
                .stream()
                .map(Team::getDetails)
                .flatMap(Collection::stream)
                .map(TeamDetail::getDesc)
                .collect(Collectors.toList());
    }
}
