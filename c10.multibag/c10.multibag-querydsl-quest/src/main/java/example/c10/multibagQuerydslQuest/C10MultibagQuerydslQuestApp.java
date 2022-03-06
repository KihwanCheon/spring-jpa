package example.c10.multibagQuerydslQuest;

import example.c10.multibagQuerydslQuest.service.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class C10MultibagQuerydslQuestApp {

    public static void main(String[] args) {
        try (var ctx = SpringApplication.run(C10MultibagQuerydslQuestApp.class, args)) {
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
