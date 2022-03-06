package example.c09.methodNamingQuest;

import example.c09.methodNamingQuest.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C09NamingMethodQuestApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C09NamingMethodQuestApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStatUp(TeamService svc) {
        return args -> {
            svc.setUp();
            svc.getTeamDescriptionsByType();
        };
    }
}
