package c06.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "team_detail")
public class TeamDetail {
    @EmbeddedId
    Pk pk;

    String desc;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;

    @Data @EqualsAndHashCode
    @NoArgsConstructor @AllArgsConstructor
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "team_id")
        Long team_id;

        String type;

        public Pk(String type) {
            this.type = type;
        }
    }
}
