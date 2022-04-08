package example.f01.jpql.embadded.service;

import example.f01.jpql.embadded.entity.Member;
import example.f01.jpql.embadded.repo.MemberRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    final TransactionWorker tx;
    final MemberRepo repo;

    public MemberService(TransactionWorker tx, MemberRepo repo) {
        this.tx = tx;
        this.repo = repo;
    }

    @Transactional
    public Member addMemberAnno(String name, String birth, String contact, String address) {
        return repo.save(Member.of(name, birth, contact, address));
    }

    @Transactional
    public void updateAnno(Member member) {
        repo.update(member.getAddress(), member.getPk());
    }

    public Member addMember(String name, String birth, String contact, String address) {
        return tx.get(() -> repo.save(Member.of(name, birth, contact, address)));
    }

    public void update(Member member) {
        tx.run(() -> repo.update(member.getAddress(), member.getPk()));
    }
}
