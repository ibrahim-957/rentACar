package kodlama.io.rentACar.Business.Concretes;

import kodlama.io.rentACar.Business.Abstracts.IBrandService;
import kodlama.io.rentACar.Business.Requests.Brand.CreateBrandRequest;
import kodlama.io.rentACar.Business.Requests.Brand.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Responses.Brand.GetAllBrandResponse;
import kodlama.io.rentACar.Business.Responses.Brand.GetByIdBrandResponse;
import kodlama.io.rentACar.Business.Rules.BrandBusinessRules;
import kodlama.io.rentACar.Core.Utilities.Mappers.ModelMapperService;
import kodlama.io.rentACar.DataAccess.Abstracts.IBrandRepository;
import kodlama.io.rentACar.Entites.Concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements IBrandService {

    private IBrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> brandResponses = brands.stream()
                .map(brand ->this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandResponse.class)).
                collect(Collectors.toList());

        return brandResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse()
                .map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest()
                        .map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest()
                .map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
