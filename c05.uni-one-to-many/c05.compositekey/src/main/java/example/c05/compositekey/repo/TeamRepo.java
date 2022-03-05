package example.c05.compositekey.repo;

import example.c05.compositekey.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
