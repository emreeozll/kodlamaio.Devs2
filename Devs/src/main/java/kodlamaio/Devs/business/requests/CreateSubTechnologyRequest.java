package kodlamaio.Devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubTechnologyRequest {

	private String subTechnologyName;
	
	private int programmingLanguageId;
	
}
