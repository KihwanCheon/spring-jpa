package example.c02.querydsl.service;

import example.c02.querydsl.entity.Member;
import example.c02.querydsl.entity.Team;
import example.c02.querydsl.repo.TeamMemberRepo;
import example.c02.querydsl.repo.TeamRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    final TeamRepo teamRepo;
    final TeamMemberRepo memberRepo;
    final EntityManager em;

    public TeamService(TeamRepo teamRepo, TeamMemberRepo memberRepo, EntityManager em) {
        this.teamRepo = teamRepo;
        this.memberRepo = memberRepo;
        this.em = em;
    }

    @Transactional
    public Long saveTeamAndReturnTeamId() {
        Team team = new Team();
        team.setName("team1");

        var savedTeam = teamRepo.save(team);
        var members = new ArrayList<Member>(100);
        for (int i = 0; i < 100; ++i) {
            var m = new Member();
            m.setTeam(savedTeam);
            m.setName("name" + i);
            members.add(m);
        }

        memberRepo.saveAll(members);
        em.clear();
        return savedTeam.getId();
    }

    public List<Member> getMembers(Long teamId) {
        return memberRepo.getProjectMembers(teamId);
    }
}
