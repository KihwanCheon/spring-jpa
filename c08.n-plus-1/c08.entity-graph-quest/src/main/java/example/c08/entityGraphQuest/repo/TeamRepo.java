package example.c08.entityGraphQuest.repo;

import example.c08.entityGraphQuest.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {

    // todo : set @EntityGraph
    @Query("select t from Team t")
    List<Team> getAllBy();
}
