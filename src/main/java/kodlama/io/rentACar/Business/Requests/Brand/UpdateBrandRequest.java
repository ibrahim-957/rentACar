package kodlama.io.rentACar.Business.Requests.Brand;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    private int id;
    @Size(min = 2, max = 30)
    private String name;
}
