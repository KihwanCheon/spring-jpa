package example.f01.jpql.embedded.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Supplier;

@Service
public class TransactionWorker {
    @Transactional
    public void run(Runnable task) {
        task.run();
    }

    @Transactional
    public <T> T get(Supplier<T> task) {
        return task.get();
    }
}
