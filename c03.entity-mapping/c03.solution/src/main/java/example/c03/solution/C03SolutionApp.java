package example.c03.solution;

import example.c03.solution.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C03SolutionApp {
    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C03SolutionApp.class, args)) {
            // run scope.
        }
    }

    @Bean
    CommandLineRunner onStartUp(TeamService svc) {
        return args -> svc.doSomeThing();
    }
}
