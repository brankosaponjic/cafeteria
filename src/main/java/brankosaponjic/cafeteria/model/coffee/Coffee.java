package brankosaponjic.cafeteria.model.coffee;

import brankosaponjic.cafeteria.model.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Coffee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {

    @Id
    private String id;
    private Brand brand;
    private CoffeeType coffeeType;
    private boolean grounded;

}