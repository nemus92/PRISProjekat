package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdmin;

	private String passAdmin;

	private String userAdmin;

	//bi-directional many-to-one association to Polazak
	@OneToMany(mappedBy="admin")
	private List<Polazak> polazaks;

	public Admin() {
	}

	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getPassAdmin() {
		return this.passAdmin;
	}

	public void setPassAdmin(String passAdmin) {
		this.passAdmin = passAdmin;
	}

	public String getUserAdmin() {
		return this.userAdmin;
	}

	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	public List<Polazak> getPolazaks() {
		return this.polazaks;
	}

	public void setPolazaks(List<Polazak> polazaks) {
		this.polazaks = polazaks;
	}

	public Polazak addPolazak(Polazak polazak) {
		getPolazaks().add(polazak);
		polazak.setAdmin(this);

		return polazak;
	}

	public Polazak removePolazak(Polazak polazak) {
		getPolazaks().remove(polazak);
		polazak.setAdmin(null);

		return polazak;
	}

}