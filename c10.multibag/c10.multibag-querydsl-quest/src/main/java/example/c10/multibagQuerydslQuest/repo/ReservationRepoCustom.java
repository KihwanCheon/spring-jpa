package example.c10.multibagQuerydslQuest.repo;

import example.c10.multibagQuerydslQuest.entity.Reservation;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ReservationRepoCustom {
    List<Reservation> getOrdersWithAssociations();
}
