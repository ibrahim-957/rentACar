package kodlama.io.rentACar.Business.Requests.Car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String  name;
    @NotNull
    @NotBlank
    @Size(min = 6,max = 8)
    private String plate;
    @NotNull
    private double dailyPrice;
    @NotNull
    private int modelYear;
    @NotNull
    private int modelId;
    @NotNull
    private int brandId;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 1)
    private int state;
}
