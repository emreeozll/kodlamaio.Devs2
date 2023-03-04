package kodlamaio.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Devs.entities.concretes.SubTechnology;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer> {

	  boolean existsBySubTechnologyNameIgnoreCase(String name);
}
