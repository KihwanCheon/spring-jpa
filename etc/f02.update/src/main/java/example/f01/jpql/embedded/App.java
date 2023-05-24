package example.f01.jpql.embedded;

import example.f01.jpql.embedded.entity.Member;
import example.f01.jpql.embedded.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        try(var ctx = SpringApplication.run(App.class, args)) {
            // run scope!
        }
    }

    @Bean
    CommandLineRunner onStartUp(MemberService svc) {
        return args -> {

            var member1 = Member.of(1, "gujjy", "1980-01-01", "000-0000-0000", "address");
            var member1DB = svc.save(member1);

            var member2 = Member.of(1, "gujjy", "1980-01-01", "000-0000-0000", null);
            var member2DB = svc.save(member2);

            var member3DB = svc.get(1);

            log.info("inserted: {}", member1DB);
            log.info("updated: {}", member2DB);
            log.info("get: {}", member3DB);
        };
    }
}
