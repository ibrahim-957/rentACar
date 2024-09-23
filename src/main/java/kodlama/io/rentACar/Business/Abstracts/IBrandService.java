package kodlama.io.rentACar.Business.Abstracts;

import kodlama.io.rentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.Responses.GetAllBrandResponse;
import kodlama.io.rentACar.Entites.Concretes.Brand;

import java.util.List;

public interface IBrandService {
    List<GetAllBrandResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
}
