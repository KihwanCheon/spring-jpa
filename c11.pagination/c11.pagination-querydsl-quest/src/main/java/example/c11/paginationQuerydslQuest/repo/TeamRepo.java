package example.c11.paginationQuerydslQuest.repo;

import example.c11.paginationQuerydslQuest.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long>, TeamRepoCustom {
}
