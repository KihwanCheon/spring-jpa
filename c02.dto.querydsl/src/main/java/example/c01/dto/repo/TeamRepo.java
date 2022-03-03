package example.c01.dto.repo;

import example.c01.dto.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
