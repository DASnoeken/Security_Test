package PowerLifters.PowerLiften.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PowerLifters.PowerLiften.domein.Coach;
import PowerLifters.PowerLiften.domein.Voortgang;

@Service
@Transactional
public class CoachService {
	@Autowired
	VoortgangRepository vr;
	
	@Autowired
	CoachRepository cr;
	
	public void geefFeedback(String feedback,long id){
		vr.setFeedback(feedback,id);
	}
	
	public Optional<Voortgang> bekijkID(Long id){
		Optional<Voortgang> IV = vr.checkID(id);
		return IV;
	}

	public String getCoachEmail(long id) {
		Coach c = cr.findById(id).get();
		return c.getEmail();
	}
	
	public void setCoach(String naam, String wachtwoord, String email) {
		Coach c = new Coach();
		c.setNaam(naam);
		c.setWachtwoord(wachtwoord);
		c.setEmail(email);
		cr.save(c);
	}
	
	public Optional<Coach> findById(long id){
		return cr.findById(id);
	}
	
	public Iterable<Coach> findCoaches() {
		Iterable<Coach> ic = cr.findAll();
		return ic;
	}
	
}
