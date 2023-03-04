package kodlamaio.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.ProgrammingLanguageService;
import kodlamaio.Devs.business.core.utilities.mappers.ModelMapperService;
import kodlamaio.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlamaio.Devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlamaio.Devs.business.responses.GetProgrammingLanguageByIdResponse;
import kodlamaio.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	@Autowired
	private ProgrammingLanguageRepository languageRepository;
	
	@Autowired
	private ModelMapperService modelMapperService;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository, ModelMapperService modelMapperService) {

		this.languageRepository = languageRepository;
		this.modelMapperService = modelMapperService;
	}

	
	private boolean isValidProgrammingLanguageName(String languageName, String creatorName) throws Exception {

		if (languageName.isEmpty() || creatorName.isEmpty()) {
			throw new Exception("Alan bos birakilamaz !");
		}

		if (languageRepository.existsByLanguageNameIgnoreCase(languageName)) {
			throw new Exception("Deger tekrar edemez !");
		}
		if (languageRepository.existsByLanguageCreatorNameIgnoreCase(creatorName)) {
			throw new Exception("Deger tekrar edemez !");
		}

		return true;
	}

	
	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

		isValidProgrammingLanguageName(createProgrammingLanguageRequest.getLanguageName(),
				createProgrammingLanguageRequest.getLanguageCreatorName());


		ProgrammingLanguage	language = this.modelMapperService.forRequest().map(createProgrammingLanguageRequest,ProgrammingLanguage.class);
		this.languageRepository.save(language);

	}

	
	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {

		// existsById boolean değerini döndürür - Verilen kimliğe sahip bir varlığın var
		// olup olmadığını döndürür.

		if (!languageRepository.existsById(deleteProgrammingLanguageRequest.getId())) {

			throw new Exception("Silme kosullari saglanamadi ! Tekrar gozden geciriniz.(Program Id Bulunamadı!)");
		} else {
			System.out.println("Silme islemi basarili.");
		}

		ProgrammingLanguage language = languageRepository.getReferenceById(deleteProgrammingLanguageRequest.getId());
		languageRepository.deleteById(language.getId());

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {

		if (!languageRepository.existsById(updateProgrammingLanguageRequest.getId())) {

			throw new Exception("Güncelleme icin kosullar saglanamadi ! (Id bos gecilemez) ");

		}

		isValidProgrammingLanguageName(updateProgrammingLanguageRequest.getLanguageName(),updateProgrammingLanguageRequest.getLanguageCreatorName());

		ProgrammingLanguage language = languageRepository.getReferenceById(updateProgrammingLanguageRequest.getId());
		language = this.modelMapperService.forRequest().map(updateProgrammingLanguageRequest,ProgrammingLanguage.class);
		this.languageRepository.save(language);
		
//      ProgrammingLanguage language = languageRepository.getReferenceById(updateProgrammingLanguageRequest.getId());
//		language.setLanguageName(updateProgrammingLanguageRequest.getLanguageName());
//		language.setLanguageCreatorName(updateProgrammingLanguageRequest.getLanguageCreatorName());
//		language.setLanguageReleaseDate(updateProgrammingLanguageRequest.getLanguageReleaseDate());
//       
//		languageRepository.save(language);

	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {

		List<ProgrammingLanguage> languages = languageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> getAllProgramLanguageResponses = new ArrayList<GetAllProgrammingLanguageResponse>();

		getAllProgramLanguageResponses = languages.stream().map(language -> this.modelMapperService.forResponse()
				.map(language, GetAllProgrammingLanguageResponse.class)).collect(Collectors.toList());

		return getAllProgramLanguageResponses;

//		for (ProgrammingLanguage language : languages) {
//
//			GetAllProgrammingLanguageResponse programLanguageResponse = new GetAllProgrammingLanguageResponse();
//			programLanguageResponse.setId(language.getId());
//			programLanguageResponse.setLanguageName(language.getLanguageName());
//			programLanguageResponse.setLanguageCreatorName(language.getLanguageCreatorName());
//			programLanguageResponse.setLanguageReleaseDate(language.getLanguageReleaseDate());
//
//			allProgramLanguageResponses.add(programLanguageResponse);
//		}

	}

	@Override
	public GetProgrammingLanguageByIdResponse getLanguageById(int id) throws Exception {

		if (!languageRepository.existsById(id)) {

			throw new Exception("Id bulunamadı !");
		}
		ProgrammingLanguage language = languageRepository.getReferenceById(id);
		GetProgrammingLanguageByIdResponse planguageById = this.modelMapperService.forResponse().map(language,
				GetProgrammingLanguageByIdResponse.class);

		return planguageById;

//		planguageById.setId(language.getId());
//		planguageById.setLanguageName(language.getLanguageName());
//		planguageById.setLanguageCreatorName(language.getLanguageCreatorName());
//		planguageById.setLanguageReleaseDate(language.getLanguageReleaseDate());

	}

}
