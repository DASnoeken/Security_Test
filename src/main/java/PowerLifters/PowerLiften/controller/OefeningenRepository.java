package PowerLifters.PowerLiften.controller;


import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import PowerLifters.PowerLiften.domein.Oefening;

public interface OefeningenRepository extends CrudRepository<Oefening,Long>{
	
	@Modifying
	@Query("delete from Oefening o")
	int clearOefeningen();
	
	@Query("select o from Oefening o where o.naam=?1")
	Optional<Oefening> findByNaam(String naam);
}
