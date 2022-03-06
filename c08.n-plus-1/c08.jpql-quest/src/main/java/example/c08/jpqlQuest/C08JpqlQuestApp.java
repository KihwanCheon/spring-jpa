package example.c08.jpqlQuest;

import example.c08.jpqlQuest.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C08JpqlQuestApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C08JpqlQuestApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStatUp(TeamService svc) {
        return args -> {
            svc.setUp();
            svc.getAllTeamDescriptions();
        };
    }
}
