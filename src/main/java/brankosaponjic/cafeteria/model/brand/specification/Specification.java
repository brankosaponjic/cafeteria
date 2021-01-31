package brankosaponjic.cafeteria.model.brand.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specification {

    private RoastLevel roastLevel;
    private List<FlavorProfile> flavorProfileList;
    private String varietal;

}
