package example.c08.jpqlQuest.repo;

import example.c08.jpqlQuest.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {

    // todo : use join fetch
    @Query("select t from Team t")
    List<Team> getTeamsWithAssociation();
}
