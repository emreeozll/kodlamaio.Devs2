package kodlamaio.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

	// jpa custom query
	boolean existsByLanguageNameIgnoreCase(String languageName);
	boolean existsByLanguageCreatorNameIgnoreCase(String creatorName);
	

	
}
