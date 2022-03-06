package example.c08.jpql.repo;

import example.c08.jpql.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    @Query("select r from Reservation r inner join fetch r.account as a " +
            " left join fetch r.seats as rs" +
            " inner join fetch rs.seat as s ")
    List<Reservation> getReservationsWithAssociations();
}
