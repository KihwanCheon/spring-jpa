package example.c11.paginationQuerydsl.repo;

import example.c11.paginationQuerydsl.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends ReservationRepoCustom, JpaRepository<Reservation, Long> {
}
