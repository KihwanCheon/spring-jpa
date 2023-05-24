package example.f01.jpql.embedded;

import example.f01.jpql.embedded.entity.Member;
import example.f01.jpql.embedded.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

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
            insertAndUpdateSingle(svc);
            insertAndUpdateMultiRows(svc);
            insertAndUpdateMultiRowsSaveAndFlush(svc);
        };
    }

    /**
     * 1st save : select insert
     * 2nd save : select update
     */
    private void insertAndUpdateSingle(MemberService svc) {
        var member1 = Member.of(0, "gujjy", "1980-01-01", "000-0000-0000", "address");
        var member1DB = svc.save(member1);

        var member2 = Member.of(0, "gujjy", "1980-01-01", "000-0000-0000", null);
        var member2DB = svc.save(member2);

        var member3DB = svc.get(0);

        log.info("inserted: {}", member1DB);
        log.info("updated: {}", member2DB);
        log.info("get: {}", member3DB);
    }

    /**
     * 1st save : select each -> insert each
     * 2nd save : select each -> insert not found rows, then update found rows.
     */
    private void insertAndUpdateMultiRows(MemberService svc) {
        try {
            svc.saveAll(buildList(1, 3, 1));
            var members = buildList(1, 5, 2);
            // members.get(2).setName(members.get(0).getName()); // violate unique on update
            members.get(3).setName(members.get(0).getName());   // violate unique on insert
            members.get(0).setName("not_conflicted");           // @Column(unique = true). priority not changed.
            svc.saveAll(members);
        } catch (Exception ignore) {

        }
    }

    /**
     * 1st save : select each -> insert each
     * 2nd save : select each -> insert or update each row.
     */
    private void insertAndUpdateMultiRowsSaveAndFlush(MemberService svc) {
        svc.saveAndFlushAll(buildList(10, 3, 1));
        var members = buildList(10, 5, 2);
        // members.get(2).setName(members.get(0).getName()); // violate unique on update
        members.get(3).setName(members.get(0).getName());   // violate unique on insert
        members.get(0).setName("not_conflicted");           // @Column(unique = true). priority not changed.
        svc.saveAndFlushAll(members);
    }

    private List<Member> buildList(int startIdx, int memberCnt, int birthMonth) {
        var ret = new ArrayList<Member>(memberCnt);
        for (int i = 1; i <= memberCnt; ++i) {
            int idx = (startIdx + i);
            ret.add(Member.of(i, "name" + idx, String.format("1980-%02d-%02d", birthMonth, idx), "contact" + idx, "address" + idx));
        }
        return ret;
    }
}
