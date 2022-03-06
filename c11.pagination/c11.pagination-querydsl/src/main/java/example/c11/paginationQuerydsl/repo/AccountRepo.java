package example.c11.paginationQuerydsl.repo;

import example.c11.paginationQuerydsl.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
