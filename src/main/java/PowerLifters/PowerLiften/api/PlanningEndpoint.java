package PowerLifters.PowerLiften.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import PowerLifters.PowerLiften.controller.CoachService;
import PowerLifters.PowerLiften.controller.GegevenTrainingService;
import PowerLifters.PowerLiften.controller.GeregistreerdeSporterService;
import PowerLifters.PowerLiften.controller.PlanningService;
import PowerLifters.PowerLiften.domein.GegevenTraining;
import PowerLifters.PowerLiften.domein.GeregistreerdeSporter;
import PowerLifters.PowerLiften.domein.Planning;


@RestController
public class PlanningEndpoint {
	@Autowired
	PlanningService ps;
	@Autowired
	GeregistreerdeSporterService gsr;
	@Autowired
	CoachService cs;
	@Autowired
	GegevenTrainingService gts;
	//@Autowired
	//private JavaMailSender javaMailSender;
	
	@GetMapping("/allPlanning")
	public Iterable<Planning> getAllPlanning(){
		Iterable<Planning> ip = ps.vindPlanning();
		return ip;
	}
	@GetMapping("/maakPlanning")
	public long maakPlanning()
	{	
		Planning p = new Planning();
		System.out.println("Planning is toegevoegd!");
		ps.opslaanPlanning(p);
		return p.getId();
	}
	
	@PostMapping("/vulPlanningSporter/{planningID}/{sporterID} ")
	public void maakPlanningSporter(@PathVariable long planningID, @PathVariable long sporterID)
	{
		System.out.println("Planning is toegevoegd! "+planningID+" "+sporterID+" maakPlanningSporter(@PathVariable long planningID, @PathVariable long sporterID)");
		ps.opslaanSporter(planningID, sporterID);
	}
	
	@PostMapping("/vulPlanningOefening/{planningID}")
	public void maakPlanningOefening(@PathVariable long planningID,@RequestBody GegevenTraining gt)
	{
		System.out.println(gt.getTijd());
		long trainingID = gts.findTrainingID(gt);
		Planning p = ps.getPlanningByID(planningID);
		System.out.println("Planning:  is toegevoegd!");
		ps.opslaanOefening(p, trainingID);
	}
	
	@PostMapping("/vulPlanningOefening2")
	public void maakPlanningOefening2(@RequestBody Planning p)
	{
		System.out.println(p);
		ps.opslaanPlanning(p);
		//System.out.println(gt.getTijd());
		//long trainingID = gts.findTrainingID(gt);
		//Planning p = ps.getPlanningByID(planningID);
		//System.out.println("Planning:  is toegevoegd!");
		//ps.opslaanOefening(p, trainingID);
	}
	
	@PostMapping("/verwijderPlanning")
	public void verwijderOefening(@RequestBody long id) {
		System.out.println("Planning: " + id + " is verwijderd!");
		ps.verwijderPlanning(id);
	}


	
	@GetMapping("/toonPlanning/{sporterID}")
	public Planning toonPlanning(@PathVariable long sporterID){
		try {
			System.out.println(sporterID);
			Planning ip = ps.vindPlanningVoorSporter(sporterID);
			System.out.println(ip);
			List<GegevenTraining> lgt = ip.getTrainingen();
			lgt.sort((a,b) -> a.getTijd().compareTo(b.getTijd()));
			ip.setTrainingen(lgt);
			return ip;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping("/stuurMail/{sporterID}")
	public void sendEmail(@PathVariable long sporterID) {
		/*
		 * String mail = cs.getCoachEmail((long)1); //HARDCODE GeregistreerdeSporter gs
		 * = gsr.vindSporterByID(sporterID); SimpleMailMessage msg = new
		 * SimpleMailMessage(); msg.setTo(mail);
		 * msg.setSubject("Reminder Planning maken"); msg.
		 * setText("Dit mailtje is een reminder voor het maken van een planning voor " +
		 * gs.getNaam()); javaMailSender.send(msg);
		 */
	}
}
