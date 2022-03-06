package example.c10.multibagQuerydslQuest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long no;
    String rows;
    int cols;

    public Seat(String row, int column) {
        this.rows = row;
        this.cols = column;
    }
}
