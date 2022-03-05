package example.c08.querydslquest.service;

import example.c08.querydslquest.entity.Team;
import example.c08.querydslquest.entity.TeamDetail;
import example.c08.querydslquest.repo.TeamRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


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
    public List<String> getAllTeamDesc() {
        return teamRepo.getTeamsWithAssociation()
                .stream()
                .map(Team::getDetails)
                .flatMap(Collection::stream)
                .map(TeamDetail::getDesc)
                .collect(Collectors.toList());
    }
}
