package PowerLifters.PowerLiften.api;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import PowerLifters.PowerLiften.controller.OefeningenService;
import PowerLifters.PowerLiften.domein.Oefening;

@RestController
public class OefeningenEndpoint {
	@Autowired
	OefeningenService os;
	
	@Value("${hoi.test}")
	String check;
	@GetMapping("/allOefeningen")
	public Iterable<Oefening> getAllOefening() {
		System.out.println(check);
		Iterable<Oefening> oefeningen = os.vindOefening();
		return oefeningen; 
	}
	
	@GetMapping("/getOefening/{id}")
	public Oefening getOefening(@PathVariable long id) {
		try {
			Oefening oefening = os.getOefeningById(id).get();
			return oefening;
		}catch(NoSuchElementException noee) {
			Oefening o = new Oefening();
			o.setNaam("ONGELDIG ID!");
			return o;
		}		
	}
	
	@PostMapping("/vulOefeningen")
	public void maakOefening(@RequestBody Oefening oefening) {
		System.out.println("Oefening: " + oefening.getNaam() + " is toegevoegd!");
		os.opslaanOefening(oefening);
	}
	@PostMapping("/leegOefeningen")
	public void leegOefeningen(){
		os.leegOefeningen();
	}
	
	@PostMapping("/vulAlleOefeningen")
	public void maakAlleOefeningen(){ //Dit geeft ons een vaste volgorde van oefeningen. Beetje boekhouding is wel handig, want het liep niet zo lekker samen met de frontend
		String[] namen = {"Deadlift","Squat","Benchpress","Barble row","Overhead press"};
		for(int i = 0; i<namen.length;i++){
			Oefening oefening = new Oefening();
			oefening.setNaam(namen[i]);
			oefening.setUitleg();
			os.opslaanOefening(oefening);
		}
	}
	
	@PostMapping("/Oefening/{naam}/image")
	public void uploadAfbeelding(@PathVariable String naam, @RequestParam("image") MultipartFile file) throws IOException {
		Optional<Oefening> oefeningZonderAfbeelding = os.getOefeningByNaam(naam);
		oefeningZonderAfbeelding.get().setFoto(file.getBytes());
		os.opslaanOefening(oefeningZonderAfbeelding.get());
	}
	
	@GetMapping("/Oefening/{naam}")
	public Oefening getOefeningByNaam(@PathVariable String naam) {
		return os.getOefeningByNaam(naam).get();
	}
	
	@GetMapping("/Oefening/{naam}/id")
	public long getOefeningIDByNaam(@PathVariable String naam) {
		return os.getOefeningByNaam(naam).get().getId();
	}
}
