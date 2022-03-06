package example.c10.multibagQuerydslQuest.repo;

import example.c10.multibagQuerydslQuest.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends ReservationRepoCustom, JpaRepository<Reservation, Long> {
}
