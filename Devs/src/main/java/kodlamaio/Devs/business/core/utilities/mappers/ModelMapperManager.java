package kodlamaio.Devs.business.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ModelMapperManager implements ModelMapperService {

	@Autowired
	private ModelMapper modelMapper;

	public ModelMapperManager(ModelMapper modelMapper) {

		this.modelMapper = modelMapper;
	}

	@Override
	public ModelMapper forRequest() {

		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper;
	}

	@Override
	public ModelMapper forResponse() {

		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper;
	}

}
