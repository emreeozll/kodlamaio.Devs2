package kodlamaio.Devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingLanguageRequest {

	
	String languageName;
	
	String languageCreatorName;
	
	String languageReleaseDate;
	
}
