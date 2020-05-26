package PowerLifters.PowerLiften.controller;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;


import PowerLifters.PowerLiften.domein.GegevenTraining;
import PowerLifters.PowerLiften.domein.GeregistreerdeSporter;
import PowerLifters.PowerLiften.domein.Planning;

public interface GegevenTrainingRepository extends CrudRepository<GegevenTraining,Long> {
	GegevenTraining findByTijd(LocalDateTime tijd);
}
