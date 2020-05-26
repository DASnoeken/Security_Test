package PowerLifters.PowerLiften.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vragenlijst {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private GeregistreerdeSporter sporter;
	
	@ManyToOne
	private Voortgang voortgang;
	
	private String vragen = "Hoe voel je je na het sporten?";
	private String antwoorden;
	
	public GeregistreerdeSporter getSporter() {
		return sporter;
	}
	public void setSporter(GeregistreerdeSporter sporter) {
		this.sporter = sporter;
	}
	public String getVragen() {
		return vragen;
	}
	public void setVragen(String vragen) {
		this.vragen = vragen;
	}
	public String getAntwoorden() {
		return antwoorden;
	}
	public void setAntwoorden(String antwoorden) {
		this.antwoorden = antwoorden;
	}
	public long getId() {
		return id;
	}
	public Voortgang getVoortgang() {
		return voortgang;
	}
	public void setVoortgang(Voortgang voortgang) {
		this.voortgang = voortgang;
	}
}
