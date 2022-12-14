package app.repository;

import app.model.Ticker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TickerRepository extends CrudRepository<Ticker, Long> {
    List<Ticker> findByMarket(String market);
}
