package example.c08.querydslquest;

import example.c08.querydslquest.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class C08QueryDslQuestApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C08QueryDslQuestApp.class, args)) {
            // run scope!
        }
    }

    CommandLineRunner onStartUp(TeamService svc) {
        return args -> {
            svc.setUp();
            log.info("{}", svc.getAllTeamDesc());
        };
    }
}
