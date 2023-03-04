package kodlamaio.Devs.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Devs.business.abstracts.SubTechnologyService;
import kodlamaio.Devs.business.requests.CreateSubTechnologyRequest;
import kodlamaio.Devs.business.requests.DeleteSubTechnologyRequest;
import kodlamaio.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllSubTechnologyResponse;
import kodlamaio.Devs.business.responses.GetSubTechnologyByIdResponse;

@RestController
@RequestMapping("/api/subTechnologies")
public class SubTechnologiesController {

	
	private SubTechnologyService subService;
	
	
	@Autowired
	public SubTechnologiesController(SubTechnologyService service) {
		
		this.subService = service;
	}


	@PostMapping("/add")
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		
		this.subService.add(createSubTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateSubTechnologyRequest updateProgrammingLanguageRequest) throws Exception {
		
		this.subService.update(updateProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest)throws Exception {
		this.subService.delete(deleteSubTechnologyRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechnologyResponse> getAll() {
		return this.subService.getAll();
		
	}
		
	@GetMapping("getbyid/{id}")
	public GetSubTechnologyByIdResponse getLanguageById(int id) throws Exception {
		
		return this.subService.getSubTechnologyById(id);
	}
	
}
