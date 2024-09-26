package kodlama.io.rentACar.Business.Responses.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandResponse {
    private int id;
    private String name;
}
