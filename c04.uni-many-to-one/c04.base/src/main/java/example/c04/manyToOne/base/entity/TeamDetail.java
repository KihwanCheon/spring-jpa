package example.c04.manyToOne.base.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "team_detail")
public class TeamDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") Long id;
    @Column(name = "type") String type;
    @Column(name = "`desc`") String desc;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;
}
