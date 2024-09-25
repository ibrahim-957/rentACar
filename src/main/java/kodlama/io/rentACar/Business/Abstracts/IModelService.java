package kodlama.io.rentACar.Business.Abstracts;

import kodlama.io.rentACar.Business.Requests.CreateModelRequest;
import kodlama.io.rentACar.Business.Requests.UpdateModelRequest;
import kodlama.io.rentACar.Business.Responses.GetAllModelsResponse;
import kodlama.io.rentACar.Business.Responses.GetModelByIdResponse;
import kodlama.io.rentACar.Business.Responses.GetModelsByBrandNameResponse;
import kodlama.io.rentACar.Entites.Concretes.Brand;
import kodlama.io.rentACar.Entites.Concretes.Model;

import java.util.List;

public interface IModelService {
    List<GetAllModelsResponse> getAll();

    GetModelByIdResponse getById(int id);

    List<GetModelsByBrandNameResponse> findByBrand(String brandName);

    void add(CreateModelRequest createModelRequest);

    void update(UpdateModelRequest updateModelRequest);

    void delete(int id);
}
