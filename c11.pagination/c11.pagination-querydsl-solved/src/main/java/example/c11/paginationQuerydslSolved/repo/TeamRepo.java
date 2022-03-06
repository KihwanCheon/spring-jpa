package example.c11.paginationQuerydslSolved.repo;

import example.c11.paginationQuerydslSolved.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long>, TeamRepoCustom {
}
