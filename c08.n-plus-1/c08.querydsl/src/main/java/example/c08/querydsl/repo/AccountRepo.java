package example.c08.querydsl.repo;

import example.c08.querydsl.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
