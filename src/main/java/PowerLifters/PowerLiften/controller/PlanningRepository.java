package PowerLifters.PowerLiften.controller;

import org.springframework.data.repository.CrudRepository;

import PowerLifters.PowerLiften.domein.GeregistreerdeSporter;
import PowerLifters.PowerLiften.domein.Planning;

public interface PlanningRepository extends CrudRepository<Planning,Long>{
	
	Planning findByGeregistreerdeSporter(GeregistreerdeSporter geregistreerdeSporter);
}
