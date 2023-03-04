package kodlamaio.Devs.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.Devs.business.abstracts.ProgrammingLanguageService;
import kodlamaio.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlamaio.Devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlamaio.Devs.business.responses.GetProgrammingLanguageByIdResponse;

@RestController
//Gelen isteğe göre genellikle model içerisinde yer alan verileri kullanarak işlem yapan ve sonucu view katmanına ileten bölümdür
@RequestMapping("/api/programlanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

		this.languageService.add(createProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
		
		this.languageService.delete(deleteProgrammingLanguageRequest);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingLanguageRequest languageRequest) throws Exception {
		this.languageService.update(languageRequest);
	}

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageResponse> getAll() {
		return this.languageService.getAll();
	}

	@GetMapping("/getbyid/{id}")
	public GetProgrammingLanguageByIdResponse getProgrammingLanguageByIdResponse(@PathVariable int id) throws Exception {

		 return this.languageService.getLanguageById(id);
	}

}
