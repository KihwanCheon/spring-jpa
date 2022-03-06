package example.c10.multibagQuerydslQuest.repo;

import example.c10.multibagQuerydslQuest.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
