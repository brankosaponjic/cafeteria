package brankosaponjic.cafeteria.repository;

import brankosaponjic.cafeteria.model.coffee.Coffee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends ReactiveMongoRepository<Coffee, String> {
}
