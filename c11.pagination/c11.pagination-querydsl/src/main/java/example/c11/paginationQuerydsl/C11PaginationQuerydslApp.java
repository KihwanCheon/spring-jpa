package example.c11.paginationQuerydsl;

import example.c11.paginationQuerydsl.service.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class C11PaginationQuerydslApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C11PaginationQuerydslApp.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(ReservationService svc) {
        return args -> {
            svc.setUp();
            svc.getPagedSeats(0, 10);
        };
    }
}
