package example.c10.multibagQuerydslSolved.repo;

import example.c10.multibagQuerydslSolved.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Long> {
}
