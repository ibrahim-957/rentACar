package kodlama.io.rentACar.DataAccess.Abstracts;

import kodlama.io.rentACar.Entites.Concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IModelRepository extends JpaRepository<Model,Integer> {
    List<Model> findByBrand_Name(String brandName);

    boolean existsByName(String name);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM Model m WHERE m.brand.id = :brandId")
    boolean hasAssociatedModels(@Param("brandId") int brandId);
}
