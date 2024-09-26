package kodlama.io.rentACar.Business.Responses.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarsByModelNameResponse {
    private int id;
    private String plate;
    private int modelYear;
    private int state;
    private String  brandName;
    private String  modelName;
}
