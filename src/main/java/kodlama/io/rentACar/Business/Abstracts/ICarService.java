package kodlama.io.rentACar.Business.Abstracts;

import kodlama.io.rentACar.Business.Requests.Car.CreateCarRequest;
import kodlama.io.rentACar.Business.Requests.Car.UpdateCarRequest;
import kodlama.io.rentACar.Business.Responses.Car.GetAllCarsResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarByIdResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarsByBrandNameResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarsByModelNameResponse;

import java.util.List;

public interface ICarService {
    List<GetAllCarsResponse> getAll();

    GetCarByIdResponse getById(int id);

    List<GetCarsByBrandNameResponse> findByBrand(String brandName);

    List<GetCarsByModelNameResponse> findByModel(String modelName);

    void add(CreateCarRequest createCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    void delete(int id);
}
