package example.c10.multibagQuerydslSolved.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "reserve_date")
    LocalDateTime reserveDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id")
    Account account;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    List<ReservationSeat> seats;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
//    Set<ReservationAttribute> attributes;
    @OrderColumn
    List<ReservationAttribute> attributes;
}
