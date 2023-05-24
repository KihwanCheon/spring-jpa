package example.f01.jpql.embedded.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class Member {

    @Id // @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long seq;
    @Column(unique = true)
    String name;
    String birth;
    String contact;
    String address;

    public static Member of(String name, String birth, String contact, String address) {
        Member ret = new Member();
        ret.setProperties(name, birth, contact, address);
        return ret;
    }

    public static Member of(long seq, String name, String birth, String contact, String address) {
        Member ret = new Member();
        ret.seq = seq;
        ret.setProperties(name, birth, contact, address);
        return ret;
    }

    void setProperties(String name, String birth, String contact, String address) {
        this.name = name;
        this.birth = birth;
        this.contact = contact;
        this.address = address;
    }
}
