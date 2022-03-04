package example.c04.cascade.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") Long id;
    @Column(name = "name") String name;
    @Column(name = "create_date") LocalDateTime createDate;
}
