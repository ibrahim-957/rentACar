package kodlama.io.rentACar.DataAccess.Abstracts;

import kodlama.io.rentACar.Business.Responses.GetModelsByBrandNameResponse;
import kodlama.io.rentACar.Entites.Concretes.Brand;
import kodlama.io.rentACar.Entites.Concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IModelRepository extends JpaRepository<Model,Integer> {
    List<Model> findByBrand_Name(String brandName);
}
