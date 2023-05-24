package example.f01.jpql.embedded.repo;

import example.f01.jpql.embedded.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepo extends CrudRepository<Member, Long> {

    <S extends Member> S saveAndFlush(S entity);
}
