package PowerLifters.PowerLiften.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PowerLifters.PowerLiften.domein.GegevenTraining;

@Service
@Transactional
public class GegevenTrainingService {
	@Autowired
	GegevenTrainingRepository gtr;

	public void opslaanTraining(GegevenTraining gt) {
		gtr.save(gt);
	}

	public long findTrainingID(GegevenTraining gt) {
		GegevenTraining a = gtr.findByTijd(gt.getTijd());
		return a.getId();
	}

}
