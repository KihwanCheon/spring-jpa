package example.c06.base.repo;

import example.c06.base.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDetailRepo extends JpaRepository<TeamDetail, Long> {
}
