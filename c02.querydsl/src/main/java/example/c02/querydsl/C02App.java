package example.c02.querydsl;

import example.c02.querydsl.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C02App {

    public static void main(String[] args) {
        try(var ctx = SpringApplication.run(C02App.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(TeamService svc) {
        return args -> {
            var id = svc.saveTeamAndReturnTeamId();
            var members = svc.getMembers(id);
            log.debug("members: {}", members.size());
        };
    }
}
