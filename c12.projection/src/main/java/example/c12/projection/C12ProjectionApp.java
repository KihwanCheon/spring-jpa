package example.c12.projection;

import example.c12.projection.service.ReservationService;
import example.c12.projection.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C12ProjectionApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C12ProjectionApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(ReservationService svc, TeamService tSvc) {
        return args -> {
            svc.setUp();
            svc.getOne();
            svc.getMulti();
            svc.getMultiWithReservedSeats();
            log.info("reservations: {}", svc.getReservationsAsJson());

            tSvc.setUp();
            log.info("teams: {}", tSvc.getTeamsAsJson());
            log.info("teams-by type: {}", tSvc.getTeamsByTypeAsJson());
        };
    }
}
