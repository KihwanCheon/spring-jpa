package example.c10.multibagQuerydslSolved.repo;

import example.c10.multibagQuerydslSolved.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
