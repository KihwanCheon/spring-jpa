package example.c11.paginationQuerydsl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor
@Entity
@Table(name = "reservation_seat")
public class ReservationSeat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne @JoinColumn(name = "seat_no")
    Seat seat;

    long price;

    public ReservationSeat(Seat seat, long price) {
        this.seat = seat;
        this.price = price;
    }
}
