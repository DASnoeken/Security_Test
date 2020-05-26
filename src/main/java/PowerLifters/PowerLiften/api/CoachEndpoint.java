package PowerLifters.PowerLiften.api;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import PowerLifters.PowerLiften.controller.CoachService;
import PowerLifters.PowerLiften.domein.Coach;
import PowerLifters.PowerLiften.domein.Voortgang;

@RestController
public class CoachEndpoint {
	@Autowired
	CoachService cs;
	
	@PostMapping("/geefFeedback")
	public void geefFeedback(@RequestBody Helper h){
		cs.geefFeedback(h.getFeedback(), h.getId());
	}
	
	@GetMapping("/checkID/{id}")
	public Optional<Voortgang> checkID(@PathVariable Long id){
		Optional<Voortgang> Il = cs.bekijkID(id);
		return Il;
	}
	
	@PostMapping("/set/coach")
	public void setInlogCoach(@RequestBody InlogCoachHelper ich) {
		cs.setCoach(ich.getNaam(), ich.getWachtwoord(),ich.getEmail());
	}
	
	@GetMapping("/get/allCoaches")
	public Iterable<Coach> getCoaches() {
		Iterable<Coach> ic = cs.findCoaches();
		return ic;
	}
	
	@GetMapping("/getCoach/{id}")
	public Coach getCoach(@PathVariable long id){
		return cs.findById(id).get();
	}
}

class InlogCoachHelper {
	
	private long id;
	private String naam;
	private String wachtwoord;
	private String email;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

class Helper{
	private String feedback;
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}	
}