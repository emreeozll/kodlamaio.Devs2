package kodlamaio.Devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguageResponse {
	
    int id;
	
	String languageName;
	
	String languageCreatorName;
	
	String languageReleaseDate;
}
