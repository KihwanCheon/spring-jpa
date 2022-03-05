package c08.base.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Data @NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id @GeneratedValue(strategy = IDENTITY)
    Long id;
    String name;

    public Account(String name) {
        this.name = name;
    }
}
