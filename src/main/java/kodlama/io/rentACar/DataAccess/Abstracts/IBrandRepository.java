package kodlama.io.rentACar.DataAccess.Abstracts;

import kodlama.io.rentACar.Entites.Concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);  //spring jpa keywords

    boolean hasAssociatedModels(int brandId);

}
