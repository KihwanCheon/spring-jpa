package example.c11.paginationQuerydsl.repo;

import example.c11.paginationQuerydsl.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Long> {
}
