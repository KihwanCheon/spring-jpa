package example.c05.cascade.repo;

import example.c05.cascade.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDetailRepo extends JpaRepository<TeamDetail, Long> {
}
