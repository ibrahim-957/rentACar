package kodlama.io.rentACar.Business.Abstracts;

import kodlama.io.rentACar.Business.Requests.Model.CreateModelRequest;
import kodlama.io.rentACar.Business.Requests.Model.UpdateModelRequest;
import kodlama.io.rentACar.Business.Responses.Model.GetAllModelsResponse;
import kodlama.io.rentACar.Business.Responses.Model.GetModelByIdResponse;
import kodlama.io.rentACar.Business.Responses.Model.GetModelsByBrandNameResponse;

import java.util.List;

public interface IModelService {
    List<GetAllModelsResponse> getAll();

    GetModelByIdResponse getById(int id);

    List<GetModelsByBrandNameResponse> findByBrand(String brandName);

    void add(CreateModelRequest createModelRequest);

    void update(UpdateModelRequest updateModelRequest);

    void delete(int id);
}
