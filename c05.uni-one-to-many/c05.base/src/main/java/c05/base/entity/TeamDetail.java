package c05.base.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "team_detail")
public class TeamDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String type;

    String desc;
}
