package example.c05.compositekey.entity;

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

    @Data @EqualsAndHashCode
    @NoArgsConstructor @AllArgsConstructor
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "team_id")
        Long team_id;

        String type;
    }
}
