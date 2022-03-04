package example.c03.challenge.repo;

import example.c03.challenge.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDetailRepo extends JpaRepository<TeamDetail, Long> {
}
