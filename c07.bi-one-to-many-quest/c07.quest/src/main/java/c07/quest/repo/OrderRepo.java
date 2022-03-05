package c07.quest.repo;

import c07.quest.entity.Order;
import org.springframework.data.repository.Repository;

public interface OrderRepo extends Repository<Order, Long> {
    Order save(Order order);

}
