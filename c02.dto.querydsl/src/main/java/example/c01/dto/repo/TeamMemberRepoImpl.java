package example.c01.dto.repo;

import example.c01.dto.entity.Member;
import example.c01.dto.entity.QMember;
import example.c01.dto.entity.QTeam;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TeamMemberRepoImpl extends QuerydslRepositorySupport
        implements TeamMemberRepoCustom {

    public TeamMemberRepoImpl() {
        super(Member.class);
    }

    @Override
    public List<Member> getProjectMembers(Long teamId) {
        var member = QMember.member;
        var team = QTeam.team;
        return from(member).innerJoin(member.team, team)
                .fetchJoin()
                .where(member.team.id.eq(teamId))
                .fetch();
    }
}
