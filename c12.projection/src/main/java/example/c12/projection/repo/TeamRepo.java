package example.c12.projection.repo;

import example.c12.projection.dto.TeamDescDto;
import example.c12.projection.dto.TeamDto;
import example.c12.projection.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TeamRepo extends JpaRepository<Team, Long>, TeamRepoCustom {

    Collection<TeamDto> findAllBy();

    Collection<TeamDescDto> findByDetails_Pk_Type(String type);
}
