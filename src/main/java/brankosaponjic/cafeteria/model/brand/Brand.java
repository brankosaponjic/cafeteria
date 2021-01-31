package brankosaponjic.cafeteria.model.brand;

import brankosaponjic.cafeteria.model.brand.specification.Specification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    private BrandName brandName;
    private String model;
    private Specification specification;
    private BrandInfo brandInfo;

}
