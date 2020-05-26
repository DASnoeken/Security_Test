package PowerLifters.PowerLiften.domein;

import java.io.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oefening {
	@Column(columnDefinition = "TEXT")		//Maakt automatisch text
	private String uitleg;
	private String naam;
	@Column(columnDefinition = "LONGBLOB")	//maakt automatisch longblob
	private byte[] foto;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public String getUitleg() {
		return uitleg;
	}
	public void setUitleg() {
		UitlegLezer ul = new UitlegLezer(naam);
		this.uitleg = ul.getUitleg();
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}

enum OefeningSoort {
	benchpress,
	deadlift,
	barblerow,
	squat,
	overheadpress
}

class UitlegLezer{
	private String uitleg;
	UitlegLezer(String naam){
		pwd();
		naam = naam.toLowerCase();
		uitleg = "";
		BufferedReader br=null;
		try {
			File f = new File("C:\\java\\Powerliften\\Powerlift_App\\src\\main\\java\\PowerLifters\\PowerLiften\\domein\\" + naam + ".txt");
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null) {
				addToUitleg(line);
			}
		}catch(FileNotFoundException fnfe) {
			System.out.println("File not found!");
			fnfe.printStackTrace();
		}catch(IOException ioe) {
			System.out.println("IOException");
			ioe.printStackTrace();
		}finally {
			if(br!=null) {
				try {
					br.close();
				}catch(IOException ioe) {
					System.out.println("Error closing file");
					ioe.printStackTrace();
				}
			}
		}
	}
	
	public void pwd() {
		File currentDirFile = new File(".");
		String helper = currentDirFile.getAbsolutePath();
		String currentDir = new String("");
		try {
			currentDir += helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());
		}catch(IOException ioe) {
			
		}
		System.out.println("current dir: "+currentDir);
	}
	
	public String getUitleg() {
		return uitleg;
	}
	
	public void addToUitleg(String s) {
		uitleg += s;
	}
}
