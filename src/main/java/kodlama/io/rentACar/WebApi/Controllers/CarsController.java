package kodlama.io.rentACar.WebApi.Controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.Business.Abstracts.ICarService;
import kodlama.io.rentACar.Business.Requests.Car.CreateCarRequest;
import kodlama.io.rentACar.Business.Requests.Car.UpdateCarRequest;
import kodlama.io.rentACar.Business.Responses.Car.GetAllCarsResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarByIdResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarsByBrandNameResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarsByModelNameResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarsController {
    private ICarService carService;

    @GetMapping
    public List<GetAllCarsResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetCarByIdResponse getByID(@PathVariable int id){
        return carService.getById(id);
    }

    @GetMapping("/{brandName}")
    public List<GetCarsByBrandNameResponse> findByBrand(@PathVariable String brandName){
        return carService.findByBrand(brandName);
    }

    @GetMapping("/{modelName}")
    public List<GetCarsByModelNameResponse> findByModel(@PathVariable String modelName){
        return carService.findByModel(modelName);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest updateCarRequest){
        this.carService.update(updateCarRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.carService.delete(id);
    }
}
