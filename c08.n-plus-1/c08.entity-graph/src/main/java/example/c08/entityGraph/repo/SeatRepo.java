package example.c08.entityGraph.repo;

import example.c08.entityGraph.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Long> {
}
