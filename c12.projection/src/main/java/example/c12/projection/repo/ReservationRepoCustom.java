package example.c12.projection.repo;

import example.c12.projection.entity.Reservation;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ReservationRepoCustom {
    List<Reservation> getOrdersWithAssociations();
}
