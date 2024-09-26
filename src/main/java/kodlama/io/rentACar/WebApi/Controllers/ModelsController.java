package kodlama.io.rentACar.WebApi.Controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.Business.Abstracts.IModelService;
import kodlama.io.rentACar.Business.Requests.Model.CreateModelRequest;
import kodlama.io.rentACar.Business.Requests.Model.UpdateModelRequest;
import kodlama.io.rentACar.Business.Responses.Model.GetAllModelsResponse;
import kodlama.io.rentACar.Business.Responses.Model.GetModelByIdResponse;
import kodlama.io.rentACar.Business.Responses.Model.GetModelsByBrandNameResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private IModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetModelByIdResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }

    @GetMapping("/{brandName}")
    public List<GetModelsByBrandNameResponse> findByBrand(@PathVariable String brandName) {
        return modelService.findByBrand(brandName);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        this.modelService.update(updateModelRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.modelService.delete(id);
    }
}
