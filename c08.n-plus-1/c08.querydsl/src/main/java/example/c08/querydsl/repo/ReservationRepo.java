package example.c08.querydsl.repo;

import example.c08.querydsl.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends ReservationRepoCustom, JpaRepository<Reservation, Long> {
}
