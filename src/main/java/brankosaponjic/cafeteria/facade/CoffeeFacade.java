package brankosaponjic.cafeteria.facade;

import brankosaponjic.cafeteria.dto.CoffeeDTO;
import brankosaponjic.cafeteria.model.coffee.Coffee;
import brankosaponjic.cafeteria.service.CoffeeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoffeeFacade {

    private final CoffeeService coffeeService;

    public CoffeeFacade(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    public CoffeeDTO createDTOObject(Coffee coffee) {

        CoffeeDTO coffeeDTO = new CoffeeDTO();
        coffeeDTO.setId(coffee.getId());
        coffeeDTO.setBrand(coffee.getBrand());
        coffeeDTO.setCoffeeType(coffee.getCoffeeType());
        coffeeDTO.setGrounded(coffee.isGrounded());

        return coffeeDTO;

    }

    public Flux<CoffeeDTO> getAllCoffees() {
        return coffeeService.getAllCoffees()
                .map(this::createDTOObject);
    }

    public Mono<CoffeeDTO> getOneCoffee(String id) {
        return coffeeService.getOneCoffee(id)
                .map(this::createDTOObject);
    }

    public Flux<CoffeeDTO> getAllGroundedCoffees(boolean isGrounded) {
        return coffeeService.getAllGroundedCoffee(isGrounded)
                .map(this::createDTOObject);
    }

    public Mono<Coffee> addCoffee(Coffee coffee) {
        return coffeeService.addCoffee(coffee);
    }

    public Mono<Void> deleteCoffee(String id) {
        return coffeeService.deleteCoffee(id);
    }

    public Mono<Coffee> updateCoffee(String id, Coffee coffee) {
        return coffeeService.updateCoffee(id, coffee);
    }
}
