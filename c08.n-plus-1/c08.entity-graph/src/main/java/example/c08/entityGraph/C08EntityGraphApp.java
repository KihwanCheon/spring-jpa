package example.c08.entityGraph;

import example.c08.entityGraph.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class C08EntityGraphApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C08EntityGraphApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(ReservationService svc) {
        return args -> {
            svc.setUp();
            var r1 = svc.getReservationsByFindAll();
            var r2 = svc.getReservationsWithAccount();
            var r3 = svc.getReservationsWithReservationSeats();
            var r4 = svc.getReservationsWithAccountAndReservationSeats();
            var r5 = svc.getReservationsWithAccountAndReservationSeatsAndSeat();

            log.info("{}", r1); // seat
            log.info("{}", r2); // seat
            log.info("{}", r3); // seat proxy - disconnected session.
            log.info("{}", r4); // seat proxy - disconnected session.
            log.info("{}", r5); // seat
        };
    }
}
