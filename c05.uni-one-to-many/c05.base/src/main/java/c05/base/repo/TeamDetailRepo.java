package c05.base.repo;

import c05.base.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDetailRepo extends JpaRepository<TeamDetail, Long> {
}
