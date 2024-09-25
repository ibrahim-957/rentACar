package kodlama.io.rentACar.Business.Concretes;

import kodlama.io.rentACar.Business.Abstracts.IModelService;
import kodlama.io.rentACar.Business.Requests.CreateModelRequest;
import kodlama.io.rentACar.Business.Requests.UpdateModelRequest;
import kodlama.io.rentACar.Business.Responses.GetAllModelsResponse;
import kodlama.io.rentACar.Business.Responses.GetModelByIdResponse;
import kodlama.io.rentACar.Business.Responses.GetModelsByBrandNameResponse;
import kodlama.io.rentACar.Core.Utilities.Mappers.ModelMapperService;
import kodlama.io.rentACar.DataAccess.Abstracts.IModelRepository;
import kodlama.io.rentACar.Entites.Concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {

    private IModelRepository modelRespository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRespository.findAll();

        List<GetAllModelsResponse> modelsResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model,GetAllModelsResponse.class))
                .collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public GetModelByIdResponse getById(int id) {
        Model model = this.modelRespository.findById(id).orElseThrow();
        GetModelByIdResponse response = this.modelMapperService.forResponse()
                .map(model,GetModelByIdResponse.class);
        return response;
    }

    @Override
    public List<GetModelsByBrandNameResponse> findByBrand(String brandName) {
        List<Model> models = modelRespository.findByBrand_Name(brandName);
        List<GetModelsByBrandNameResponse> modelsByBrandNameResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetModelsByBrandNameResponse.class))
                .collect(Collectors.toList());
        return modelsByBrandNameResponses;
    }


    @Override
    public void add(CreateModelRequest createModelRequest) {

        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRespository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
        this.modelRespository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRespository.deleteById(id);
    }
}
