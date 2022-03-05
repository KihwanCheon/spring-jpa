package example.c07.solved;

import example.c07.solved.service.OrderService;
import example.c07.solved.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C07SolvedApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C07SolvedApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStatUp(TeamService svc, OrderService oSvc) {
        return args -> {
            svc.doSomething();
            oSvc.doSomething();
        };
    }
}
