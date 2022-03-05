package example.c08.querydslSolved.repo;

import example.c08.querydslSolved.entity.Team;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TeamRepoCustom {
    List<Team> getTeamsWithAssociation();
}
