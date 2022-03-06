package example.c11.paginationQuerydslQuest;

import example.c11.paginationQuerydslQuest.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C11PaginationQueryDslQuestApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C11PaginationQueryDslQuestApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(TeamService svc) {
        return args -> {
            svc.setUp();
            log.info("{}", svc.getPagedTeams(0, 5));
        };
    }
}
