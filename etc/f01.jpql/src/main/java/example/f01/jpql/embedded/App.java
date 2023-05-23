package example.f01.jpql.embedded;

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
            var member = svc.addMemberAnno("gujjy", "1980-01-01", "000-0000-0000", null);
            member.setAddress("korea");
            svc.updateAnno(member);
            log.info("");
            log.info("");
            log.info("");
            var member2 = svc.addMember("gujjy1", "1980-01-01", "000-0000-0000", null);
            member2.setAddress("korea");
            svc.update(member2);
        };

    }

}
