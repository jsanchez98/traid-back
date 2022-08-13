package app.repository;

import app.model.Trader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TraderRepository extends CrudRepository<Trader, Long> {
    List<Trader> findByUsername(String username);
}
