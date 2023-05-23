package example.f01.jpql.embedded.repo;

import example.f01.jpql.embedded.entity.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepo extends CrudRepository<Member, Member.Pk> {

    @Modifying
    @Query("update Member set address = ?1 where pk = ?2")
    void update(String address, Member.Pk pk);
}
