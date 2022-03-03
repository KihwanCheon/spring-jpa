package example.c02.querydsl.repo;

import example.c02.querydsl.entity.Member;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TeamMemberRepoCustom {
    List<Member> getProjectMembers(Long teamId);
}
