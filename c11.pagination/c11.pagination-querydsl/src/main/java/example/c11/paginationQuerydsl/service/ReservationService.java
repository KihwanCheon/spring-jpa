package example.c11.paginationQuerydsl.service;

import example.c11.paginationQuerydsl.entity.Account;
import example.c11.paginationQuerydsl.entity.Reservation;
import example.c11.paginationQuerydsl.entity.ReservationSeat;
import example.c11.paginationQuerydsl.entity.Seat;
import example.c11.paginationQuerydsl.repo.AccountRepo;
import example.c11.paginationQuerydsl.repo.ReservationRepo;
import example.c11.paginationQuerydsl.repo.SeatRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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
        List<Reservation> ordersWithAssociations = reservationRepo.getOrdersWithAssociations();
        return getSeats(ordersWithAssociations);
    }

    @Transactional(readOnly = true)
    public List<Seat> getPagedSeats(int page, int size) {
        return getSeats(reservationRepo.getPagedOrdersWithAssociations(PageRequest.of(page, size)).getContent());
    }

    List<Seat> getSeats(List<Reservation> ordersWithAssociations) {
        return ordersWithAssociations.stream()
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
