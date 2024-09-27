package kodlama.io.rentACar.Business.Concretes;

import kodlama.io.rentACar.Business.Abstracts.IModelService;
import kodlama.io.rentACar.Business.Requests.Model.CreateModelRequest;
import kodlama.io.rentACar.Business.Requests.Model.UpdateModelRequest;
import kodlama.io.rentACar.Business.Responses.Model.GetAllModelsResponse;
import kodlama.io.rentACar.Business.Responses.Model.GetModelByIdResponse;
import kodlama.io.rentACar.Business.Responses.Model.GetModelsByBrandNameResponse;
import kodlama.io.rentACar.Core.Utilities.Mappers.ModelMapperService;
import kodlama.io.rentACar.DataAccess.Abstracts.IModelRepository;
import kodlama.io.rentACar.Entites.Concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {

    private IModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    @Transactional(readOnly = true)
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model,GetAllModelsResponse.class))
                .collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    @Transactional(readOnly = true)
    public GetModelByIdResponse getById(int id) {
        Model model = this.modelRepository.findById(id).orElseThrow();
        GetModelByIdResponse response = this.modelMapperService.forResponse()
                .map(model,GetModelByIdResponse.class);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetModelsByBrandNameResponse> findByBrand(String brandName) {
        List<Model> models = modelRepository.findByBrand_Name(brandName);
        List<GetModelsByBrandNameResponse> modelsByBrandNameResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetModelsByBrandNameResponse.class))
                .collect(Collectors.toList());
        return modelsByBrandNameResponses;
    }

    @Override
    @Transactional
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }

    @Override
    @Transactional
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
        this.modelRepository.save(model);
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }
}
