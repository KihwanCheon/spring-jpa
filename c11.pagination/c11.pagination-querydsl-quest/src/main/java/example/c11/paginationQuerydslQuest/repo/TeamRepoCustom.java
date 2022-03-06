package example.c11.paginationQuerydslQuest.repo;

import example.c11.paginationQuerydslQuest.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TeamRepoCustom {
    List<Team> getTeamsWithAssociation();

    Page<Team> getPagedTeamsWithAssociation(Pageable pageable);
}
