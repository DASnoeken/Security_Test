package PowerLifters.PowerLiften.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import PowerLifters.PowerLiften.controller.VoortgangService;
import PowerLifters.PowerLiften.domein.Voortgang;

@RestController
public class VoortgangEndpoint {

	@Autowired
	VoortgangService vs;
	
	@GetMapping("/allVoortgang")
	public Iterable<Voortgang> getAllVoortgang(){
		Iterable<Voortgang> iv = vs.vindVoortgang();
		return iv;
	}
	
	@PostMapping("/vulVoortgang/{naam}")
	public long maakVoortgang(@RequestBody Voortgang voortgang, @PathVariable String naam){
		System.out.println("Voortgang: " + voortgang.getLiftaantal() + " is toegevoegd! id = "+voortgang.getId());
		vs.opslaanVoortgang(voortgang, naam);
		System.out.println("In maakVoortgang() is het ID: "+vs.getID());
		return vs.getID();
	}
	
	@PostMapping("/verwijderOefening")
	public void verwijderOefening(@RequestBody Long id) {
		System.out.println("Voortgang: " + id + " is verwijderd!");
		vs.verwijderVoortgang(id);
	}
	
	@PostMapping("/voortgangAntwoord")
	public void voorgangAntwoord(@RequestBody HelperVoortgang h) {
		vs.geefAntwoord(h.getAntwoord(), h.getId());
	}
}

class HelperVoortgang{
	private String antwoord;
	private long id;
	public String getAntwoord() {
		return antwoord;
	}
	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}