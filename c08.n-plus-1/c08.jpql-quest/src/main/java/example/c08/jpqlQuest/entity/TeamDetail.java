package example.c08.jpqlQuest.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "team_detail")
public class TeamDetail {
    @EmbeddedId Pk pk;
    String desc;

    @ManyToOne
    @MapsId("teamId")
    Team team;

    @Data @EqualsAndHashCode
    @NoArgsConstructor
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "team_id")
        Long teamId;
        String type;

        public Pk(String type) {
            this.type = type;
        }
    }
}
