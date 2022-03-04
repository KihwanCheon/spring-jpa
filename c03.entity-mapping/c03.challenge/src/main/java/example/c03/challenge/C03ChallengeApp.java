package example.c03.challenge;

import example.c03.challenge.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C03ChallengeApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C03ChallengeApp.class, args)) {
            // run scope.
        }
    }

    @Bean
    CommandLineRunner onStartUp(TeamService svc) {
        return args -> svc.doSomeThing();
    }
}
