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

    public void checkIfBrandExistsById(int id){
        if(!brandRepository.existsById(id)){
            throw new BusinessException("Brand not found with the given ID");
        }
    }

    public void checkBrandNameLength(String name){
        if ((name.length()<2) || (name.length()>30)){
            throw new BusinessException("Brand name must be between 2 and 30 characters");
        }
    }

    public void checkIfBrandHasAssociatedModels(int brandId){
        if (brandRepository.hasAssociatedModels(brandId)){
            throw new BusinessException("Cannot delete a brand that has associated models");
        }
    }

    public void checkIfBrandNameIsEmptyOrNull(String name){
        if (name == null || name.trim().isEmpty()){
            throw new BusinessException("Brand name cannot be null or empty");
        }
    }


}
