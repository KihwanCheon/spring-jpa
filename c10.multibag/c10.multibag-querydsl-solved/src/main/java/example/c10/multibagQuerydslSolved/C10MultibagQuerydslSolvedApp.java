package example.c10.multibagQuerydslSolved;

import example.c10.multibagQuerydslSolved.service.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class C10MultibagQuerydslSolvedApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C10MultibagQuerydslSolvedApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(ReservationService svc) {
        return args -> {
            svc.setUp();
            svc.getOne();
            svc.getMulti();
            svc.getMultiWithReservedSeats();
        };
    }
}
