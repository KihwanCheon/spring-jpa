package example.c09.methodNamingSovled.repo;

import example.c09.methodNamingSovled.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {

    List<Team> findByDetails_Pk_Type(String type);
}
