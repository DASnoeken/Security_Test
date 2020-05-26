package PowerLifters.PowerLiften.domein;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class GegevenTraining {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Oefening oefening;
	private LocalDateTime tijd;
	private int aantalReps;
	private int gewicht;
	
	public LocalDateTime getTijd() {
		return tijd;
	}
	public void setTijd(LocalDateTime tijd) {
		this.tijd = tijd;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Oefening getOefening() {
		return oefening;
	}
	public void setOefening(Oefening oefening) {
		this.oefening = oefening;
	}
	public int getAantalReps() {
		return aantalReps;
	}
	public void setAantalReps(int aantalReps) {
		this.aantalReps = aantalReps;
	}
	public int getGewicht() {
		return gewicht;
	}
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	
	
}
