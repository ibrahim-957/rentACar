package kodlama.io.rentACar.Business.Rules;

import kodlama.io.rentACar.Business.Abstracts.IModelService;
import kodlama.io.rentACar.Core.Utilities.Exceptions.BusinessException;
import kodlama.io.rentACar.DataAccess.Abstracts.IModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private IModelRepository modelRepository;

    public void checkIfModelNameExists(String name){
        if (this.modelRepository.existsByName(name)){
            throw new BusinessException("Model name already exists");
        }
    }

    public void checkIfModelExistsById(int id){
        if (!modelRepository.existsById(id)){
            throw new BusinessException("Model not found with the given ID");
        }
    }

    public void checkModelNameLength(String name){
        if((name.length()<3)||(name.length()>30)){
            throw new BusinessException("Model name must be between 3 and 30 characters");
        }
    }

    public void checkIfModelHasAssociatedCars(int modelId){
        if (modelRepository.hasAssociatedModels(modelId)){
            throw new BusinessException("Cannot delete a model that has associated models");
        }
    }

    public void checkIfModelNameIsEmptyOrNull(String name){
        if (name==null || name.trim().isEmpty()){
            throw new BusinessException("Model name cannot be null or empty");
        }
    }

    public void checkIfBrandExistsById(int id){
        if (!modelRepository.existsById(id)){
            throw new BusinessException("Brand not found with the given ID, please first add brand");
        }
    }
}
