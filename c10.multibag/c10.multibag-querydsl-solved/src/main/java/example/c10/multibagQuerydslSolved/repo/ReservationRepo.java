package example.c10.multibagQuerydslSolved.repo;

import example.c10.multibagQuerydslSolved.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends ReservationRepoCustom, JpaRepository<Reservation, Long> {
}
