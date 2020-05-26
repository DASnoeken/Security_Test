package PowerLifters.PowerLiften.domein;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voortgang {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Oefening oefening;
	private float oefeningtijd;
	private int liftaantal;
	private double gebruiktegewicht;
	private LocalDateTime starttijd;
	private String feedback;
	private String antwoorden;
	
	public String getAntwoorden() {
		return antwoorden;
	}
	public void setAntwoorden(String antwoorden) {
		this.antwoorden = antwoorden;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public long getId() {
		return id;
	}
	public Oefening getOefening() {
		return oefening;
	}
	public void setOefening(Oefening oefening) {
		this.oefening = oefening;
	}
	public float getOefeningtijd() {
		return oefeningtijd;
	}
	public void setOefeningtijd(float oefeningtijd) {
		this.oefeningtijd = oefeningtijd;
	}
	public int getLiftaantal() {
		return liftaantal;
	}
	public void setLiftaantal(int liftaantal) {
		this.liftaantal = liftaantal;
	}
	public double getGebruiktegewicht() {
		return gebruiktegewicht;
	}
	public void setGebruiktegewicht(double gebruiktegewicht) {
		this.gebruiktegewicht = gebruiktegewicht;
	}
	public LocalDateTime getStarttijd() {
		return starttijd;
	}
	public void setStarttijd(LocalDateTime starttijd) {
		this.starttijd = starttijd;
	}
}
