package c07.solved.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "order_date")
    LocalDateTime orderDate;

    // TODO : Set RelationShip!
    List<OrderDetail> details = new ArrayList<>();

}
