package kodlama.io.rentACar.DataAccess.Abstracts;

import kodlama.io.rentACar.Entites.Concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IBrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);  //spring jpa keywords

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM Model m WHERE m.brand.id = :brandId")
    boolean hasAssociatedModels(int brandId);

}
