package kodlama.io.rentACar.DataAccess.Abstracts;

import kodlama.io.rentACar.Entites.Concretes.Car;
import kodlama.io.rentACar.Entites.Concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByBrandName(String brandName);

    List<Car> findByModelName(String modelName);
}
