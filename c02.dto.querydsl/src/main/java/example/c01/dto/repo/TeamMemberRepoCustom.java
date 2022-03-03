package example.c01.dto.repo;

import example.c01.dto.entity.Member;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TeamMemberRepoCustom {
    List<Member> getProjectMembers(Long teamId);
}
