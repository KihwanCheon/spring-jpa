package example.c08.querydslSolved.repo;

import example.c08.querydslSolved.entity.QTeam;
import example.c08.querydslSolved.entity.QTeamDetail;
import example.c08.querydslSolved.entity.Team;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TeamRepoImpl extends QuerydslRepositorySupport implements TeamRepoCustom {

    public TeamRepoImpl() {
        super(Team.class);
    }

    @Override
    public List<Team> getTeamsWithAssociation() {
        QTeam team = QTeam.team;
        QTeamDetail detail = QTeamDetail.teamDetail;
        return from(team)
                .innerJoin(team.details, detail).fetchJoin()
                .fetch();
    }
}
