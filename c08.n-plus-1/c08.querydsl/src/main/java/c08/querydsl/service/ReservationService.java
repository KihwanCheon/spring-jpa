package c08.querydsl.service;

import c08.querydsl.entity.Account;
import c08.querydsl.entity.Reservation;
import c08.querydsl.entity.ReservationSeat;
import c08.querydsl.entity.Seat;
import c08.querydsl.repo.AccountRepo;
import c08.querydsl.repo.ReservationRepo;
import c08.querydsl.repo.SeatRepo;
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
        return reservationRepo.getOrdersWithAssociations().stream()
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
}
