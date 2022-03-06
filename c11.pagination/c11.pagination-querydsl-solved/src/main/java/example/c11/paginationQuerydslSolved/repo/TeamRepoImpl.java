package example.c11.paginationQuerydslSolved.repo;

import com.querydsl.jpa.JPQLQuery;
import example.c11.paginationQuerydslSolved.entity.QTeam;
import example.c11.paginationQuerydslSolved.entity.QTeamDetail;
import example.c11.paginationQuerydslSolved.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TeamRepoImpl extends QuerydslRepositorySupport implements TeamRepoCustom {

    QTeam team = QTeam.team;
    QTeamDetail detail = QTeamDetail.teamDetail;

    public TeamRepoImpl() {
        super(Team.class);
    }

    @Override
    public List<Team> getTeamsWithAssociation() {
        return from(team)
                .innerJoin(team.details, detail).fetchJoin()
                .fetch();
    }

    @Override
    public Page<Team> getPagedTeamsWithAssociation(Pageable pageable) {

        // todo : extract id.
        JPQLQuery<Long> query = from(team).select(team.id);
        JPQLQuery<Long> pagedQuery = getQuerydsl().applyPagination(pageable, query);

        long totCnt;
        try {
            totCnt = pagedQuery.fetchCount();
        } catch (Exception e) {
            totCnt = 0;
        }

        List<Long> ids = pagedQuery.fetch();
        // todo : select - fetch with in relationship
        List<Team> list = from(team)
                .innerJoin(team.details, detail).fetchJoin()
                .where(team.id.in(ids))
                .fetch();

        return new PageImpl<>(list, pageable, totCnt);
    }
}
