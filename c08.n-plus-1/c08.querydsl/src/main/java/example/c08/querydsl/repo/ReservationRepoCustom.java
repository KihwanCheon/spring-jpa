package example.c08.querydsl.repo;

import example.c08.querydsl.entity.Reservation;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ReservationRepoCustom {
    List<Reservation> getOrdersWithAssociations();
}
