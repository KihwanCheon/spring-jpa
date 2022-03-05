package example.c06.mapsId.repo;

import example.c06.mapsId.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
