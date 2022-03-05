package c08.querydsl.repo;

import c08.querydsl.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends ReservationRepoCustom, JpaRepository<Reservation, Long> {
}
