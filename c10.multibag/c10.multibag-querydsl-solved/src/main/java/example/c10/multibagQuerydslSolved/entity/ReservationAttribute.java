package example.c10.multibagQuerydslSolved.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor
@Entity
@Table(name = "reservation_attribute")
public class ReservationAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String attribute;

    public ReservationAttribute(String attr) {
        this.attribute = attr;
    }
}
