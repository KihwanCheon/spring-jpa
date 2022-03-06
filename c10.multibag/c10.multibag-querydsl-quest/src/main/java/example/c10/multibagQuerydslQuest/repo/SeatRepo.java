package example.c10.multibagQuerydslQuest.repo;

import example.c10.multibagQuerydslQuest.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Long> {
}
