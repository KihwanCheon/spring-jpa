package example.c08.jpql;

import example.c08.jpql.service.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class C08JpqlApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C08JpqlApp.class, args)) {
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
