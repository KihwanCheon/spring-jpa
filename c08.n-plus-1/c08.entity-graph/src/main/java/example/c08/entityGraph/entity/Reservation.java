package example.c08.entityGraph.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "withAccount", attributeNodes = {
                @NamedAttributeNode("account")
        }),
        @NamedEntityGraph(name = "withReservationSeats", attributeNodes = {
                @NamedAttributeNode("seats")
        }),
        @NamedEntityGraph(name = "withAccountAndReservationSeats", attributeNodes = {
                @NamedAttributeNode("account"),
                @NamedAttributeNode("seats")
        }),
        @NamedEntityGraph(name = "withAccountAndReservationSeatsAndSeat", attributeNodes = {
                @NamedAttributeNode("account"),
                @NamedAttributeNode(value = "seats", subgraph = "seats")},
                subgraphs = {
                    @NamedSubgraph(name = "seats", attributeNodes = {@NamedAttributeNode("seat")
                    })
        })
})
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
}
