package kodlama.io.rentACar.Business.Abstracts;

import kodlama.io.rentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.Requests.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Responses.GetAllBrandResponse;
import kodlama.io.rentACar.Business.Responses.GetByIdBrandResponse;

import java.util.List;

public interface IBrandService {
    List<GetAllBrandResponse> getAll();

    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}
