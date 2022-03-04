package example.c04.manyToOne.base;

import example.c04.manyToOne.base.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C04BaseApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C04BaseApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStatUp(TeamService svc) {
        return args -> svc.doSomething();
    }
}
