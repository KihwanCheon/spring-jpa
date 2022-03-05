package example.c07.solved.repo;

import example.c07.solved.entity.Order;
import org.springframework.data.repository.Repository;

public interface OrderRepo extends Repository<Order, Long> {
    Order save(Order order);

}
