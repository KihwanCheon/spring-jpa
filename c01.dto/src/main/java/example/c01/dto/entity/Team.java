package example.c01.dto.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;

    private String name;
}
