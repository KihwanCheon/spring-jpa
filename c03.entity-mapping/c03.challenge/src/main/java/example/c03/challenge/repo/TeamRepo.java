package example.c03.challenge.repo;

import example.c03.challenge.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
