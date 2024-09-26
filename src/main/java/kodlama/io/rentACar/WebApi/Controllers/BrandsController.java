package kodlama.io.rentACar.WebApi.Controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.Business.Abstracts.IBrandService;
import kodlama.io.rentACar.Business.Requests.Brand.CreateBrandRequest;
import kodlama.io.rentACar.Business.Requests.Brand.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Responses.Brand.GetAllBrandResponse;
import kodlama.io.rentACar.Business.Responses.Brand.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private IBrandService brandService;

    @GetMapping()
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
