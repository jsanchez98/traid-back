package app.repository;

import app.model.PolygonResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PolygonRepository extends CrudRepository<PolygonResponse, Long> {
    PolygonResponse findByTicker(String ticker);
    boolean existsPolygonResponseByTicker(String ticker);
}
