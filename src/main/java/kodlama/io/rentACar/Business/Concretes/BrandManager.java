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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class BrandManager implements IBrandService {

    private IBrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    @Transactional(readOnly = true)
    public List<GetAllBrandResponse> getAll() {
        log.info("Fetching all brands...");
        List<Brand> brands = brandRepository.findAll();
        log.debug("Number of brands fetches: {}", brands.size());

        List<GetAllBrandResponse> brandResponses = brands.stream()
                .map(brand ->this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandResponse.class)).
                collect(Collectors.toList());

        log.info("Returning {} brands", brands.size());
        return brandResponses;
    }

    @Override
    @Transactional(readOnly = true)
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse()
                .map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    @Transactional
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameIsEmptyOrNull(createBrandRequest.getName());
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        this.brandBusinessRules.checkBrandNameLength(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest()
                        .map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    @Transactional
    public void update(UpdateBrandRequest updateBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameIsEmptyOrNull(updateBrandRequest.getName());
        this.brandBusinessRules.checkIfBrandExistsById(updateBrandRequest.getId());
        this.brandBusinessRules.checkBrandNameLength(updateBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest()
                .map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.brandBusinessRules.checkIfBrandExistsById(id);
        this.brandBusinessRules.checkIfBrandHasAssociatedModels(id);
        this.brandRepository.deleteById(id);
    }
}
