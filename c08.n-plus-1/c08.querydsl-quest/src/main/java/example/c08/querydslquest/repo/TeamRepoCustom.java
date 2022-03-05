package example.c08.querydslquest.repo;

import example.c08.querydslquest.entity.Team;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TeamRepoCustom {
    List<Team> getTeamsWithAssociation();
}
