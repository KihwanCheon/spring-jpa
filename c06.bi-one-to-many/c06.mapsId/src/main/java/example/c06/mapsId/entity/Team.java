package example.c06.mapsId.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    List<TeamDetail> details = new ArrayList<>();
}
