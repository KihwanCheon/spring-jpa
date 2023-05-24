package example.f01.jpql.embedded.service;

import example.f01.jpql.embedded.entity.Member;
import example.f01.jpql.embedded.repo.MemberRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    final MemberRepo repo;

    public MemberService(MemberRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public Member save(Member member) {
        return repo.save(member);
    }

    public Member get(long seq) {
        return repo.findById(seq).orElse(null);
    }
}
