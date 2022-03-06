package example.c11.paginationQuerydsl.repo;

import com.querydsl.jpa.JPQLQuery;
import example.c11.paginationQuerydsl.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ReservationRepoImpl extends QuerydslRepositorySupport implements ReservationRepoCustom {

    QReservation r = QReservation.reservation;
    QAccount a = QAccount.account;
    QReservationSeat rs = QReservationSeat.reservationSeat;
    QSeat s = QSeat.seat;

    public ReservationRepoImpl() {
        super(Reservation.class);
    }

    @Override
    public List<Reservation> getReservationsWithAssociations() {
        return from(r).innerJoin(r.account, a).fetchJoin()
                .leftJoin(r.seats, rs).fetchJoin()
                .innerJoin(rs.seat, s).fetchJoin()
                .fetch();
    }

    @Override
    public Page<Reservation> getPagedReservationsWithAssociations(Pageable pageable) {

//        return way_count_id_where(pageable);
        return way_select_reservation_only(pageable);
//        return way_select_reservation_fetch_join(pageable);
    }

    /** pagination but multiple queries */
    PageImpl<Reservation> way_count_id_where(Pageable pageable) {
        // pagination query.
        var pagedQuery = getQuerydsl().applyPagination(pageable, from(r).select(r.id));
        long totCnt = getTotalQueryCnt(pagedQuery);

        var ids = pagedQuery.fetch();
        // fetch join where ids.
        var list = from(r).innerJoin(r.account, a).fetchJoin()
                .leftJoin(r.seats, rs).fetchJoin()
                .innerJoin(rs.seat, s).fetchJoin()
                .where(r.id.in(ids))
                .fetch();
        return new PageImpl<>(list, pageable, totCnt);
    }

    /** pagination but not fetch join */
    Page<Reservation> way_select_reservation_only(Pageable pageable) {
        // how to fetch join??
        var query = from(r).innerJoin(r.account, a)/*.fetchJoin()*/
                .leftJoin(r.seats, rs)/*.fetchJoin()*/
                .innerJoin(rs.seat, s)/*.fetchJoin()*/;

        var pagedQuery = getQuerydsl().applyPagination(pageable, query);
        long totCnt = getTotalQueryCnt(pagedQuery); // count 4;
        var list = pagedQuery.fetch();
        return new PageImpl<>(list, pageable, totCnt); // fetched 1 reservation.
    }

    /** not working pagination. */
    Page<Reservation> way_select_reservation_fetch_join(Pageable pageable) {
        // with fetch join. no limit clause.
        var query = from(r).innerJoin(r.account, a).fetchJoin()
                .leftJoin(r.seats, rs).fetchJoin()
                .innerJoin(rs.seat, s).fetchJoin();

        var pagedQuery = getQuerydsl().applyPagination(pageable, query);
        long totCnt = getTotalQueryCnt(pagedQuery); // count 4;
        var list = pagedQuery.fetch();
        return new PageImpl<>(list, pageable, totCnt); // fetched 4 reservation, account, seats
    }

    <T> long getTotalQueryCnt(JPQLQuery<T> query) {
        long totCnt;
        try {
            totCnt = query.fetchCount();
        } catch (Exception e) {
            totCnt = 0;
        }
        return totCnt;
    }
}
