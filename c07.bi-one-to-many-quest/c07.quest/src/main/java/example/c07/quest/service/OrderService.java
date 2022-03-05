package example.c07.quest.service;

import example.c07.quest.entity.Order;
import example.c07.quest.entity.OrderDetail;
import example.c07.quest.repo.OrderRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class OrderService {
    final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public void doSomething() {
        var order = new Order();
        order.setOrderDate(LocalDateTime.now());

        var detail0 = new OrderDetail("t0");
        detail0.setDesc("desc0");
        detail0.setOrder(order);

        var detail1 = new OrderDetail("t1");
        detail1.setDesc("desc1");
        detail1.setOrder(order);

        order.getDetails().add(detail0);
        order.getDetails().add(detail1);

        repo.save(order);
    }
}
