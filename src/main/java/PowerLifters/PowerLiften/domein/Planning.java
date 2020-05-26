package PowerLifters.PowerLiften.domein;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Planning {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToMany
	private List<GegevenTraining> training = new ArrayList<GegevenTraining>();
	@OneToOne
	private GeregistreerdeSporter geregistreerdeSporter;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<GegevenTraining> getTrainingen() {
		return training;
	}
	public void setTrainingen(List<GegevenTraining> training) {
		this.training = training;
	}
	public GeregistreerdeSporter getSporter() {
		return geregistreerdeSporter;
	}
	public void setSporter(GeregistreerdeSporter geregistreerdeSporter) {
		this.geregistreerdeSporter = geregistreerdeSporter;
	}
	public void addTrainingen(GegevenTraining gt) {
		training.add(gt);
	}
	

	
	
	
	
	
}
