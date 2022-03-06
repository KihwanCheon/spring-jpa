package example.c12.projection.repo;

import example.c12.projection.dto.ReservationDto;
import example.c12.projection.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepo extends ReservationRepoCustom, JpaRepository<Reservation, Long> {
    List<ReservationDto> findAllBy();
}
