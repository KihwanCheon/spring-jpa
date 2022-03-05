package c07.solved.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data @NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @EmbeddedId
    Pk pk = new Pk();

    String desc;

    // TODO : Set RelationShip!
    Order order;

    public OrderDetail(String type) {
        this.pk.setType(type);
    }

    @Data @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "order_id")
        Long orderId;

        String type;
    }
}
