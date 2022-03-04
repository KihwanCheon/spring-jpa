package example.c04.manyToOne.base.repo;

import example.c04.manyToOne.base.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDetailRepo extends JpaRepository<TeamDetail, Long> {
}
