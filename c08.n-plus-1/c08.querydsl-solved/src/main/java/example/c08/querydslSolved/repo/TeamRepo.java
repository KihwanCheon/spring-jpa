package example.c08.querydslSolved.repo;

import example.c08.querydslSolved.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long>, TeamRepoCustom {
}
