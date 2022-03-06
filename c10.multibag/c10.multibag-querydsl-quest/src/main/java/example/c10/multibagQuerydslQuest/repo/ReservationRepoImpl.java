package example.c10.multibagQuerydslQuest.repo;

import example.c10.multibagQuerydslQuest.entity.*;
import example.c10.multibagQuerydslQuest.entity.Reservation;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ReservationRepoImpl extends QuerydslRepositorySupport implements ReservationRepoCustom {
    public ReservationRepoImpl() {
        super(Reservation.class);
    }

    @Override
    public List<Reservation> getOrdersWithAssociations() {
        QReservation r = QReservation.reservation;
        QAccount a = QAccount.account;
        QReservationSeat rs = QReservationSeat.reservationSeat;
        QSeat s = QSeat.seat;
        QReservationAttribute ra = QReservationAttribute.reservationAttribute;

        return from(r).innerJoin(r.account, a).fetchJoin()
                .leftJoin(r.seats, rs).fetchJoin()
                .leftJoin(r.attributes, ra).fetchJoin()
                .innerJoin(rs.seat, s).fetchJoin()
                .fetch();
    }
}
