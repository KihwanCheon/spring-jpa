package example.c04.manyToOne.base.repo;

import example.c04.manyToOne.base.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
