package example.c12.projection.repo;

import example.c12.projection.entity.Team;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TeamRepoCustom {
    List<Team> getTeamsWithAssociation();
}
