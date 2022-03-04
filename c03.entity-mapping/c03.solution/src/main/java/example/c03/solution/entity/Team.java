package example.c03.solution.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") Long id;
    @Column(name = "name") String name;
    @Column(name = "create_date") LocalDateTime createDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    List<TeamDetail> details = new ArrayList<>();
}
