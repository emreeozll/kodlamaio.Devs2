package kodlamaio.Devs.entities.concretes;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProgramLanguage")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "language_name")
	private String languageName;

	@Column(name = "language_creator_name")
	private String languageCreatorName;

	@Column(name = "language_release_date")
	private String languageReleaseDate;
	
	@OneToMany(mappedBy = "programmingLanguage", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<SubTechnology> subTechnologies;

}
