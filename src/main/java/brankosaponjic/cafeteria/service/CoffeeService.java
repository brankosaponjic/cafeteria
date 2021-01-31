package brankosaponjic.cafeteria.service;

import brankosaponjic.cafeteria.model.coffee.Coffee;
import brankosaponjic.cafeteria.repository.CoffeeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Flux<Coffee> getAllCoffees() {
        return coffeeRepository.findAll()
                .delayElements(Duration.ofSeconds(3))
                .log();
    }

    public Mono<Coffee> getOneCoffee(String id) {
        return coffeeRepository.findById(id);
    }

    public Flux<Coffee> getAllGroundedCoffee(boolean isGrounded) {
        return coffeeRepository.findAll()
                .filter(coffee -> coffee.isGrounded() == true)
                .delayElements(Duration.ofSeconds(3))
                .log();
    }

    public Mono<Coffee> addCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee)
                .log("Coffee is saved");
    }

    public Mono<Void> deleteCoffee(String id) {
        return coffeeRepository.deleteById(id)
                .log("Coffee is deleted");
    }

    public Mono<Coffee> updateCoffee(String id, Coffee newCoffee) {
        return coffeeRepository.findById(id)
                .flatMap(coffee -> {
                    coffee.setId(newCoffee.getId());
                    coffee.setCoffeeType(newCoffee.getCoffeeType());
                    coffee.setBrand(newCoffee.getBrand());
                    coffee.setGrounded(newCoffee.isGrounded());
                    return coffeeRepository.save(coffee);
                })
                .log("Coffee is updated");
    }
}
