package example.c11.paginationQuerydslSolved;

import example.c11.paginationQuerydslSolved.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C11PaginationQueryDslSolvedApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C11PaginationQueryDslSolvedApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(TeamService svc) {
        return args -> {
            svc.setUp();
            var list = svc.getPagedTeams(0, 5);
            log.info("{} {}", list.size(), list.get(0));
        };
    }
}
