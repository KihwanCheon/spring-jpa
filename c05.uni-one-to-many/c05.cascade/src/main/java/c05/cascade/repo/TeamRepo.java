package c05.cascade.repo;

import c05.cascade.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
