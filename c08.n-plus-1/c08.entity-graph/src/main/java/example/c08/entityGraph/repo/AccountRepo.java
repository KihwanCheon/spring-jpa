package example.c08.entityGraph.repo;

import example.c08.entityGraph.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
