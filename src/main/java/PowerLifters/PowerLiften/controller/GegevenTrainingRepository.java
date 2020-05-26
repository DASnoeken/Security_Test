package PowerLifters.PowerLiften.controller;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import PowerLifters.PowerLiften.domein.GegevenTraining;

public interface GegevenTrainingRepository extends CrudRepository<GegevenTraining,Long> {
	GegevenTraining findByTijd(LocalDateTime tijd);
}
