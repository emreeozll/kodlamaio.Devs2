package kodlamaio.Devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingLanguageRequest {

	private int id;

	private String languageName;

	private String languageCreatorName;

	private String languageReleaseDate;

}
