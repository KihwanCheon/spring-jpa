package example.c07.quest.entity;

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

    @Data @EqualsAndHashCode
    @NoArgsConstructor
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "order_id")
        Long orderId;

        String type;
    }
}
