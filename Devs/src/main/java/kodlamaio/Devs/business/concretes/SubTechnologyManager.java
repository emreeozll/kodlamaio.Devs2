package kodlamaio.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.SubTechnologyService;
import kodlamaio.Devs.business.core.utilities.mappers.ModelMapperService;
import kodlamaio.Devs.business.requests.CreateSubTechnologyRequest;
import kodlamaio.Devs.business.requests.DeleteSubTechnologyRequest;
import kodlamaio.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllSubTechnologyResponse;
import kodlamaio.Devs.business.responses.GetSubTechnologyByIdResponse;
import kodlamaio.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlamaio.Devs.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {

	@Autowired
	private SubTechnologyRepository subRepository;

	@Autowired
	private ModelMapperService modelMapperService;

	public SubTechnologyManager(SubTechnologyRepository subRepository, ModelMapperService modelMapperService) {

		this.subRepository = subRepository;
		this.modelMapperService = modelMapperService;
	}

	private boolean isValidSubTechnology(String subTechnologyName) throws Exception {

		if (subTechnologyName.isEmpty()) {

			throw new Exception("İsim alani bos birakilamaz !");
		}

		if (subRepository.existsBySubTechnologyNameIgnoreCase(subTechnologyName)) {
			throw new Exception("Teknoloji adı tekrar edemez. !");
		}

		return true;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {

		isValidSubTechnology(createSubTechnologyRequest.getSubTechnologyName());

		SubTechnology subTechnology = new SubTechnology();
		subTechnology = this.modelMapperService.forRequest().map(createSubTechnologyRequest, SubTechnology.class);
		subRepository.save(subTechnology);

	}

	@Override
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) throws Exception {

		if (!subRepository.existsById(deleteSubTechnologyRequest.getId())) {

			throw new Exception("Silme kosulu olan alt teknoloji Id bulunamadı! Tekrar gozden geciriniz.");
		} else {
			System.out.println("Silme islemi basarili.");
		}

		SubTechnology subTechnology = subRepository.findById(deleteSubTechnologyRequest.getId()).orElseThrow();
		subRepository.deleteById(subTechnology.getId());

	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {

		if (!subRepository.existsById(updateSubTechnologyRequest.getId())) {

			throw new Exception("Güncelleme icin kosullar saglanamadi ! (Id bos gecilemez) ");
		}

		isValidSubTechnology(updateSubTechnologyRequest.getSubTechnologyName());

		SubTechnology subTechnology = subRepository.getReferenceById(updateSubTechnologyRequest.getId());
		subTechnology = this.modelMapperService.forRequest().map(updateSubTechnologyRequest, SubTechnology.class);
		subRepository.save(subTechnology);

//ProgrammingLanguage language = languageRepository.findById(updateSubTechnologyRequest.getProgrammingLanguageId()).orElseThrow();		
//		subTechnology.setSubTechnologyName(updateSubTechnologyRequest.getSubTechnologyName());
//		subTechnology.setProgrammingLanguage(language);
//		System.out.println();
//		

	}

	@Override
	public GetSubTechnologyByIdResponse getSubTechnologyById(int id) throws Exception {

		// optinal null ayiklamayi saglar. opsiyon saglar, id'nin olup - olmama durumunu
		// belirtir.
		// Daha farkli bir hata tepkisine gerek kalmadi.

		SubTechnology subTechnology = subRepository.findById(id).orElseThrow();
		GetSubTechnologyByIdResponse subById = new GetSubTechnologyByIdResponse();

		subById = this.modelMapperService.forResponse().map(subTechnology, GetSubTechnologyByIdResponse.class);
		return subById;

	}

	@Override
	public List<GetAllSubTechnologyResponse> getAll() {

		List<SubTechnology> subTechnologies = subRepository.findAll();
		List<GetAllSubTechnologyResponse> allSubTechnologyResponses = new ArrayList<GetAllSubTechnologyResponse>();

		allSubTechnologyResponses = subTechnologies.stream().map(subTechnology -> this.modelMapperService.forResponse()
				.map(subTechnology, GetAllSubTechnologyResponse.class)).collect(Collectors.toList());

		return allSubTechnologyResponses;
	}

}
