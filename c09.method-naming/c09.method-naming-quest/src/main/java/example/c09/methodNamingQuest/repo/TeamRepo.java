package example.c09.methodNamingQuest.repo;

import example.c09.methodNamingQuest.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {

    // todo : remove Query annotation and rename method.
    @Query("select t from Team t left join fetch t.details td where td.pk.type = ?1")
    List<Team> changeMethodName(String type);
}
