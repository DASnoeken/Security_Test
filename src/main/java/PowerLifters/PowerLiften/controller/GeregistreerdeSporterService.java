package PowerLifters.PowerLiften.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PowerLifters.PowerLiften.domein.GeregistreerdeSporter;

@Service
@Transactional
public class GeregistreerdeSporterService {

	@Autowired
	GeregistreerdeSporterRepository gsr;
	
	public void opslaanRegistratie(GeregistreerdeSporter r) {
		System.out.println("User " + r.getNaam() + " wordt opgeslagen!");
		gsr.save(r);
		
	}

	public Iterable<GeregistreerdeSporter> vindSporters() {
		Iterable<GeregistreerdeSporter> sporters = gsr.findAll();
		return sporters;
	}

	public GeregistreerdeSporter vindSporterByID(long id) {
		GeregistreerdeSporter gs = gsr.findById(id).get();
		return gs;
	}
}
