package example.c01.simple.repo;

import example.c01.simple.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepo extends JpaRepository<Member, Long> {
    List<Member> findByTeam_Id(Long teamId);
}
