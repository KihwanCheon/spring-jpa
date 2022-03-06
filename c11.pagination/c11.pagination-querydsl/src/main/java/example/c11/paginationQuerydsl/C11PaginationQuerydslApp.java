package example.c11.paginationQuerydsl;

import example.c11.paginationQuerydsl.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
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
            var pagedSeats = svc.getPagedSeats(0, 2);
            log.info("{} :: {}", pagedSeats.size(), pagedSeats);
        };
    }
}
