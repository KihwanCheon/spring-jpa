package example.c01.dto.repo;

import example.c01.dto.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepo extends TeamMemberRepoCustom, JpaRepository<Member, Long> {
    List<Member> findByTeam_Id(Long teamId);
}
