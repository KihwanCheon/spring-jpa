package example.c08.jpql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

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
