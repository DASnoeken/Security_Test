package PowerLifters.PowerLiften.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PowerLifters.PowerLiften.domein.GeregistreerdeSporter;
import PowerLifters.PowerLiften.domein.Vragenlijst;

@Service
@Transactional
public class VragenlijstService {
	@Autowired
	VoortgangRepository vor;
	
	@Autowired
	VragenlijstRepository vr;
	
	@Autowired
	GeregistreerdeSporterRepository gsr;
	
	public void opslaanAntwoorden(Vragenlijst v, long id) {
		Optional<GeregistreerdeSporter> sporter = gsr.findById(id);
		GeregistreerdeSporter gs = sporter.get();
		v.setSporter(gs);
		vr.save(v);
	}
	
	public Iterable<Vragenlijst> getAllVragenlijsten() {
		Iterable<Vragenlijst> vragenlijsten = vr.findAll();
		return vragenlijsten;
	}
	
	public Optional<Vragenlijst> getVragenlijstById(long id) {
		Optional<Vragenlijst> v = vr.findById(id);
		return v;
	}
}
