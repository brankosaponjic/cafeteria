package brankosaponjic.cafeteria.model.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandInfo {

    private int founded;
    private String founder;
    private String headquarters;

}
