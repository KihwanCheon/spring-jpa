package c08.querydsl.repo;

import c08.querydsl.entity.*;
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

        return from(r).innerJoin(r.account, a).fetchJoin()
                .leftJoin(r.seats, rs).fetchJoin()
                .innerJoin(rs.seat, s).fetchJoin()
                .fetch();
    }
}
