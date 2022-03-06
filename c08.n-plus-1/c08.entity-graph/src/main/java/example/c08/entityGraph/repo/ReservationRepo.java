package example.c08.entityGraph.repo;

import example.c08.entityGraph.entity.Reservation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    @EntityGraph("withAccount")
    List<Reservation> getAllBy();

    @EntityGraph("withReservationSeats")
    List<Reservation> readAllBy();

    @EntityGraph("withAccountAndReservationSeats")
    List<Reservation> queryAllBy();

    @EntityGraph("withAccountAndReservationSeatsAndSeat")
    List<Reservation> findAllBy();

}
