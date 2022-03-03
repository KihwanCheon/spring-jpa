package example.c02.querydsl.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "name") private String name;

    @ManyToOne @JoinColumn(name = "team_id")
    private Team team;
}
