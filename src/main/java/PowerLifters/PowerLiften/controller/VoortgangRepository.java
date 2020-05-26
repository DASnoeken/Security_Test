package PowerLifters.PowerLiften.controller;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import PowerLifters.PowerLiften.domein.Voortgang;

public interface VoortgangRepository extends CrudRepository<Voortgang,Long> {
	
	@Query("select v from Voortgang v where v.id = ?1")
	Optional<Voortgang> checkID(long id);
	
	@Modifying
	@Query("update Voortgang v set v.feedback = ?1 where v.id = ?2")
	int setFeedback(String feedback,long id);
}
