package brankosaponjic.cafeteria.controller;

import brankosaponjic.cafeteria.constants.PathConstants;
import brankosaponjic.cafeteria.dto.CoffeeDTO;
import brankosaponjic.cafeteria.facade.CoffeeFacade;
import brankosaponjic.cafeteria.model.coffee.Coffee;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(PathConstants.READ)
public class CoffeeController {

    private final CoffeeFacade coffeeFacade;

    public CoffeeController(CoffeeFacade coffeeFacade) {
        this.coffeeFacade = coffeeFacade;
    }

    @GetMapping()
    public Flux<CoffeeDTO> readAll() {
        return coffeeFacade.getAllCoffees();
    }

    @GetMapping("/{id}")
    public Mono<CoffeeDTO> readOne(@PathVariable("id") String id) {
        return coffeeFacade.getOneCoffee(id);
    }

    @GetMapping(PathConstants.GROUNDED)
    public Flux<CoffeeDTO> readAllGrounded(boolean isGrounded) {
        return coffeeFacade.getAllGroundedCoffees(isGrounded);
    }

    @PostMapping(PathConstants.CREATE)
    public Mono<Coffee> addCoffee(@RequestBody Coffee coffee) {
        return coffeeFacade.addCoffee(coffee);
    }

    @PutMapping(PathConstants.UPDATE + "/{id}")
    public Mono<Coffee> updateCoffee(@PathVariable("id") String id, @RequestBody Coffee coffee) {
        return coffeeFacade.updateCoffee(id, coffee);
    }

    @DeleteMapping(PathConstants.DELETE + "/{id}")
    public Mono<Void> deleteCoffee(@PathVariable("id") String id) {
        return coffeeFacade.deleteCoffee(id);
    }
}