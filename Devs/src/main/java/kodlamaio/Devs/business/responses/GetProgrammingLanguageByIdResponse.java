package kodlamaio.Devs.business.responses;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProgrammingLanguageByIdResponse {

	
	private int id;
	
	private String languageName;


	private String languageCreatorName;


	private String languageReleaseDate;
}
