package kodlama.io.rentACar.Core.Utilities.Mappers;

import kodlama.io.rentACar.Business.Requests.Model.CreateModelRequest;
import kodlama.io.rentACar.Entites.Concretes.Model;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        this.modelMapper.typeMap(CreateModelRequest.class, Model.class)
                .addMappings(mapper -> mapper.skip(Model::setId));

        return this.modelMapper;

    }
}
