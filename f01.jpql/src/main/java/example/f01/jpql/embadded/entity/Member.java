package example.f01.jpql.embadded.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "member")
public class Member {

    @EmbeddedId Pk pk;
    String contact;
    String address;

    public static Member of(String name, String birth, String contact, String address) {
        var ret = new Member();
        ret.setPk(new Pk(name, birth));
        ret.contact = contact;
        ret.address = address;
        return ret;
    }

    @Data @AllArgsConstructor @NoArgsConstructor
    @Embeddable
    public static class Pk implements Serializable {
        String name;
        String birth;
    }
}
