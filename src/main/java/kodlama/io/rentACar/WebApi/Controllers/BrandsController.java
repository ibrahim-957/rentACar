package kodlama.io.rentACar.WebApi.Controllers;

import kodlama.io.rentACar.Business.Abstracts.IBrandService;
import kodlama.io.rentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.Responses.GetAllBrandResponse;
import kodlama.io.rentACar.Entites.Concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private IBrandService brandService;

    @Autowired
    public BrandsController(IBrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/getall")
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
}
