package example.c11.paginationQuerydsl.repo;

import example.c11.paginationQuerydsl.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.NoRepositoryBean;

import org.springframework.data.domain.Pageable;
import java.util.List;

@NoRepositoryBean
public interface ReservationRepoCustom {
    List<Reservation> getOrdersWithAssociations();
    Page<Reservation> getPagedOrdersWithAssociations(Pageable pageable);
}
