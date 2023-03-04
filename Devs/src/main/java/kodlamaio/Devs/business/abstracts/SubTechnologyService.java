package kodlamaio.Devs.business.abstracts;

import java.util.List;

import kodlamaio.Devs.business.requests.CreateSubTechnologyRequest;
import kodlamaio.Devs.business.requests.DeleteSubTechnologyRequest;
import kodlamaio.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllSubTechnologyResponse;
import kodlamaio.Devs.business.responses.GetSubTechnologyByIdResponse;

public interface SubTechnologyService {

	void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;
	
	void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest)throws Exception;
	
	void update(UpdateSubTechnologyRequest updateSubTechnologyrequest) throws Exception;
	
	List<GetAllSubTechnologyResponse> getAll();
	
	GetSubTechnologyByIdResponse getSubTechnologyById(int id) throws Exception;

	
	
	
	
	
}
