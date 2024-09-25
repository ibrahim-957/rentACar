package kodlama.io.rentACar.Business.Rules;

import kodlama.io.rentACar.Core.Utilities.Exceptions.BusinessException;
import kodlama.io.rentACar.DataAccess.Abstracts.IBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

    private IBrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists");  // java exeption types

        }
    }
}
