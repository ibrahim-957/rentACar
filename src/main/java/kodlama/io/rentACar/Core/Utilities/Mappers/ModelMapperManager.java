package kodlama.io.rentACar.Core.Utilities.Mappers;

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
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
