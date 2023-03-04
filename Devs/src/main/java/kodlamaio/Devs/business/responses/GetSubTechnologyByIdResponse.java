package kodlamaio.Devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSubTechnologyByIdResponse {

	private int id;
	
	private String subTechnologyName;
	
	private int programmingLangaudeId;
	
	
}
