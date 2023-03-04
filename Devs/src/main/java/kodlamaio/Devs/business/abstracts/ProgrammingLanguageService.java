package kodlamaio.Devs.business.abstracts;

import java.util.List;



import kodlamaio.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlamaio.Devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlamaio.Devs.business.responses.GetProgrammingLanguageByIdResponse;

public interface ProgrammingLanguageService {

// Veri tabanı varligini döndürmek yasak - O yuzden response ve request pattern'li mimari
//	List<ProgramLanguage> getAll();

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest)throws Exception;

	void update(UpdateProgrammingLanguageRequest updateLanguageRequest) throws Exception;

	List<GetAllProgrammingLanguageResponse> getAll();

	GetProgrammingLanguageByIdResponse getLanguageById(int id)throws Exception ;
	

}
