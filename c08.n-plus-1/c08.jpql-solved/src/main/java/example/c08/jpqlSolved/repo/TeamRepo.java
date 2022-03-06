package example.c08.jpqlSolved.repo;

import example.c08.jpqlSolved.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {

    @Query("select t from Team t left join fetch t.details as td")
    List<Team> getTeamsWithAssociation();
}
