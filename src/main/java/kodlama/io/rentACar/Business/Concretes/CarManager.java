package kodlama.io.rentACar.Business.Concretes;

import kodlama.io.rentACar.Business.Abstracts.ICarService;
import kodlama.io.rentACar.Business.Requests.Car.CreateCarRequest;
import kodlama.io.rentACar.Business.Requests.Car.UpdateCarRequest;
import kodlama.io.rentACar.Business.Responses.Car.GetAllCarsResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarByIdResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarsByBrandNameResponse;
import kodlama.io.rentACar.Business.Responses.Car.GetCarsByModelNameResponse;
import kodlama.io.rentACar.Business.Responses.Model.GetModelsByBrandNameResponse;
import kodlama.io.rentACar.Core.Utilities.Mappers.ModelMapperService;
import kodlama.io.rentACar.DataAccess.Abstracts.ICarRepository;
import kodlama.io.rentACar.Entites.Concretes.Car;
import kodlama.io.rentACar.Entites.Concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements ICarService {
    private ICarRepository carRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();

        List<GetAllCarsResponse> carsResponses = cars.stream().map(car -> this.modelMapperService.forResponse()
                .map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
        return carsResponses;
    }

    @Override
    public GetCarByIdResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        GetCarByIdResponse response = this.modelMapperService.forResponse()
                .map(car, GetCarByIdResponse.class);
        return response;
    }

    @Override
    public List<GetCarsByBrandNameResponse> findByBrand(String brandName) {
        List<Car> cars = carRepository.findByBrandName(brandName);
        List<GetCarsByBrandNameResponse> carsByBrandNameResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car, GetCarsByBrandNameResponse.class))
                .collect(Collectors.toList());
        return carsByBrandNameResponses;
    }

    @Override
    public List<GetCarsByModelNameResponse> findByModel(String modelName) {
        List<Car> cars = carRepository.findByModelName(modelName);
        List<GetCarsByModelNameResponse> carsByModelNameResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car, GetCarsByModelNameResponse.class))
                .collect(Collectors.toList());
        return carsByModelNameResponses;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);
    }
}
