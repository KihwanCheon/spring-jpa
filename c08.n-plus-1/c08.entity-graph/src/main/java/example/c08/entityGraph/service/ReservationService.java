package example.c08.entityGraph.service;

import example.c08.entityGraph.entity.Account;
import example.c08.entityGraph.entity.Reservation;
import example.c08.entityGraph.entity.ReservationSeat;
import example.c08.entityGraph.entity.Seat;
import example.c08.entityGraph.repo.AccountRepo;
import example.c08.entityGraph.repo.ReservationRepo;
import example.c08.entityGraph.repo.SeatRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ReservationService {

    final AccountRepo accountRepo;
    final ReservationRepo reservationRepo;
    final SeatRepo seatRepo;

    public ReservationService(AccountRepo accountRepo, ReservationRepo reservationRepo, SeatRepo seatRepo) {
        this.accountRepo = accountRepo;
        this.reservationRepo = reservationRepo;
        this.seatRepo = seatRepo;
    }

    @Transactional
    public void setUp() {
        var seat0 = addSeat("A", 0);
        var seat1 = addSeat("A", 1);
        var seat2 = addSeat("B", 0);
        var seat3 = addSeat("B", 2);

        var account0 = addAccount("name0");

        var reservedSeat0 = reserveSeat(seat0, 5000);
        var reservedSeat1 = reserveSeat(seat1, 4500);

        var reservation0 = reserve(account0, reservedSeat0, reservedSeat1);

        var account1 = addAccount("name1");

        var reservedSeat2 = reserveSeat(seat2, 5000);
        var reservedSeat3 = reserveSeat(seat3, 4500);

        var reservation1 = reserve(account1, reservedSeat2, reservedSeat3);
    }

    public Optional<Reservation> getOne() {
        return reservationRepo.findById(1L);
    }

    public List<Reservation> getMulti() {
        return reservationRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<Seat> getMultiWithReservedSeats() {
        return reservationRepo.findAll().stream()
                .map(Reservation::getSeats)
                .flatMap(Collection::stream)
                .map(ReservationSeat::getSeat)
                .collect(Collectors.toList());
    }

    Seat addSeat(String row, int column) {
        var seat = new Seat(row, column);
        return seatRepo.save(seat);
    }

    Account addAccount(String name) {
        var account = new Account(name);
        return accountRepo.save(account);
    }

    ReservationSeat reserveSeat(Seat seat, long price) {
        return new ReservationSeat(seat, price);
    }

    Reservation reserve(Account account, ReservationSeat ... reservationSeats) {
        var reservation = new Reservation();
        reservation.setAccount(account);
        reservation.setReserveDate(LocalDateTime.now());
        reservation.setSeats(Arrays.asList(reservationSeats));
        return reservationRepo.save(reservation);
    }

    /**
     * Query reservation list -> 2 queries each account -> 2 queries each seat with left join reservations.
     * Return seat fetched in stream loops.
     * Total 5 queries
     */
    @Transactional(readOnly = true)
    public List<Seat> getReservationsByFindAll() {
        return getAll(reservationRepo.findAll());
    }

    /**
     * Query reservation with left join account -> 2 queries each seat with left join reservations.
     * Return seat fetched in stream loops.
     * Total 3 queries.
     */
    @Transactional(readOnly = true)
    public List<Seat> getReservationsWithAccount() {
        return getAll(reservationRepo.getAllBy());
    }

    /**
     * Query reservation with left join reservedSeat.
     * Total 1 queries.
     * Not fetched seats.
     * Return proxy seats in session.
     */
    @Transactional(readOnly = true)
    public List<Seat> getReservationsWithReservationSeats() {
        return getAll(reservationRepo.readAllBy());
    }

    /**
     * Query reservation with left join account, reservedSeat.
     * Not fetched seats.
     * Total 1 queries.
     * Return proxy seats in session.
     */
    @Transactional(readOnly = true)
    public List<Seat> getReservationsWithAccountAndReservationSeats() {
        return getAll(reservationRepo.queryAllBy());
    }

    /**
     * Query reservation with left join account, reservedSeat, seat.
     * Fetched seats.
     * Total 1 queries.
     * Return fetched seats.
     */
    @Transactional(readOnly = true)
    public List<Seat> getReservationsWithAccountAndReservationSeatsAndSeat() {
        return getAll(reservationRepo.findAllBy());
    }

    List<Seat> getAll(List<Reservation> reservations) {
        return reservations.stream()
                .map(Reservation::getSeats)
                .flatMap(Collection::stream)
                .map(ReservationSeat::getSeat)
                .collect(Collectors.toList());
    }
}
