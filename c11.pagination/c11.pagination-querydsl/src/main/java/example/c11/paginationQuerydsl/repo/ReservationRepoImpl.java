package example.c11.paginationQuerydsl.repo;

import example.c11.paginationQuerydsl.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Reservation> getPagedOrdersWithAssociations(Pageable pageable) {
        QReservation r = QReservation.reservation;
        QAccount a = QAccount.account;
        QReservationSeat rs = QReservationSeat.reservationSeat;
        QSeat s = QSeat.seat;

        // pagination query.
        var pagedQuery = getQuerydsl().applyPagination(pageable, from(r).select(r.id));
        long totCnt;
        try {
            totCnt = pagedQuery.fetchCount();
        } catch (Exception e) {
            totCnt = 0;
        }

        var ids = pagedQuery.fetch();
        // fetch join where ids.
        return new PageImpl<>(from(r).innerJoin(r.account, a).fetchJoin()
                .leftJoin(r.seats, rs).fetchJoin()
                .innerJoin(rs.seat, s).fetchJoin()
                .where(r.id.in(ids))
                .fetch(), pageable, totCnt);
    }
}
