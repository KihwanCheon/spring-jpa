package example.c08.querydslSolved;

import example.c08.querydslSolved.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C08QueryDslSolvedApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C08QueryDslSolvedApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(TeamService svc) {
        return args -> {
            svc.setUp();
            // 1 team, 2 details -> 2 team-detail joined rows -> 2 teams loop get each 2 details -> 4 details !!
            log.info("{}", svc.getAllTeamDesc());
        };
    }
}
