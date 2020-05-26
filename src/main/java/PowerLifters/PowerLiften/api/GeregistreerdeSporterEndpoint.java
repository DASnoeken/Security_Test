package PowerLifters.PowerLiften.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import PowerLifters.PowerLiften.controller.GeregistreerdeSporterService;
import PowerLifters.PowerLiften.domein.GeregistreerdeSporter;

@RestController
public class GeregistreerdeSporterEndpoint {

	@Autowired
	GeregistreerdeSporterService gss;
	
	@PostMapping("/registreerdeSporter")
	public void getTestParam(@RequestBody GeregistreerdeSporter r) {
		System.out.println(r.getNaam() + " is opgeslagen");
		gss.opslaanRegistratie(r);
	}
	
	@GetMapping("/allSporters")
	public Iterable<GeregistreerdeSporter> getSporters(){
		Iterable<GeregistreerdeSporter> sporters = gss.vindSporters();
		return sporters; 
	}
	
	@GetMapping("/getSporter/{id}")
	public GeregistreerdeSporter getSporterByID(@PathVariable long id) {
		GeregistreerdeSporter gs = gss.vindSporterByID(id);
		return gs;
	}
	
}
