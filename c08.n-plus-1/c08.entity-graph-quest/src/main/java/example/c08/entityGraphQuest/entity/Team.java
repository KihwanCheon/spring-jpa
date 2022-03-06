package example.c08.entityGraphQuest.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// todo : Set @NamedEntityGraph
@Data
@Entity
@Table(name = "team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "create_date")
    LocalDateTime createDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    List<TeamDetail> details = new ArrayList<>();
}
