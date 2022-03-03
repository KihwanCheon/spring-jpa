package example.c02.querydsl.repo;

import example.c02.querydsl.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepo extends TeamMemberRepoCustom, JpaRepository<Member, Long> {
    List<Member> findByTeam_Id(Long teamId);
}
