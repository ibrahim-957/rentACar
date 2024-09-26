package kodlama.io.rentACar.Business.Requests.Car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    @NotNull
    @NotBlank
    private String  name;
    @NotNull
    @NotBlank
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
    private int state;
}
