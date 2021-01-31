package brankosaponjic.cafeteria.dto;

import brankosaponjic.cafeteria.model.brand.Brand;
import brankosaponjic.cafeteria.model.coffee.CoffeeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDTO {

    private String id;
    private Brand brand;
    private CoffeeType coffeeType;
    @JsonIgnore
    private boolean grounded;
}
