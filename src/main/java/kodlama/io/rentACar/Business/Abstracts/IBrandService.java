package kodlama.io.rentACar.Business.Abstracts;

import kodlama.io.rentACar.Business.Requests.Brand.CreateBrandRequest;
import kodlama.io.rentACar.Business.Requests.Brand.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Responses.Brand.GetAllBrandResponse;
import kodlama.io.rentACar.Business.Responses.Brand.GetByIdBrandResponse;

import java.util.List;

public interface IBrandService {
    List<GetAllBrandResponse> getAll();

    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}
