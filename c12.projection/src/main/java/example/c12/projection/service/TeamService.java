package example.c12.projection.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import example.c12.projection.entity.Team;
import example.c12.projection.entity.TeamDetail;
import example.c12.projection.repo.TeamRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    final ObjectWriter mapper;

    final TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;

        var module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new CustomDateJsonSerializer());
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(module)
                .writerWithDefaultPrettyPrinter();
    }

    @Transactional
    public void setUp() {
        var team = new Team();
        team.setName("team1");
        team.setCreateDate(LocalDateTime.now());

        var detail0 = new TeamDetail();
        detail0.setPk(new TeamDetail.Pk("t1"));
        detail0.setDesc("desc1");
        detail0.setTeam(team);

        var detail1 = new TeamDetail();
        detail1.setPk(new TeamDetail.Pk("t2"));
        detail1.setDesc("desc2");
        detail1.setTeam(team);

        team.getDetails().add(detail0);
        team.getDetails().add(detail1);

        teamRepo.save(team);
    }

    @Transactional(readOnly = true)
    public List<String> getAllTeamDesc() {
        return teamRepo.getTeamsWithAssociation()
                .stream()
                .map(Team::getDetails)
                .flatMap(Collection::stream)
                .map(TeamDetail::getDesc)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<String> getAllTeamDescWithFindAll() {
        return teamRepo.findAll()
                .stream()
                .map(Team::getDetails)
                .flatMap(Collection::stream)
                .map(TeamDetail::getDesc)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public String getTeamsAsJson() throws JsonProcessingException {
        return mapper.writeValueAsString(teamRepo.findAllBy());
    }

    @Transactional(readOnly = true)
    public String getTeamsByTypeAsJson() throws JsonProcessingException {
        return mapper.writeValueAsString(teamRepo.findByDetails_Pk_Type("t1"));
    }
}
