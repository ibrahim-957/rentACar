package kodlama.io.rentACar.Business.Concretes;

import kodlama.io.rentACar.Business.Abstracts.IBrandService;
import kodlama.io.rentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.Responses.GetAllBrandResponse;
import kodlama.io.rentACar.DataAccess.Abstracts.IBrandRepository;
import kodlama.io.rentACar.Entites.Concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements IBrandService {

    private IBrandRepository brandRepository;

    @Autowired
    public BrandManager(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponse> brandResponses = new ArrayList<>();

        for (Brand brand : brands){
            GetAllBrandResponse responseItem = new GetAllBrandResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandResponses.add(responseItem);
        }
        return brandResponses;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        brandRepository.save(brand);
    }
}
