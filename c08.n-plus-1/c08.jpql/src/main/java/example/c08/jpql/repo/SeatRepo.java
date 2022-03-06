package example.c08.jpql.repo;

import example.c08.jpql.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Long> {
}
