package kodlama.io.rentACar.Business.Requests.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
    @NotNull
    private int id;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    private int brandId;
}
