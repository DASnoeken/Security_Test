package PowerLifters.PowerLiften.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Afbeelding {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] file;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
}
