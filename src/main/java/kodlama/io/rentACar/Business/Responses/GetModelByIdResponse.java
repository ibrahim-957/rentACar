package kodlama.io.rentACar.Business.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelByIdResponse {
    private int id;
    private String name;
}
