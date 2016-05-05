package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the polazak database table.
 * 
 */
@Entity
@NamedQuery(name="Polazak.findAll", query="SELECT p FROM Polazak p")
public class Polazak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPolazak;

	private String vrstaPolaska;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	private Admin admin;

	public Polazak() {
	}

	public int getIdPolazak() {
		return this.idPolazak;
	}

	public void setIdPolazak(int idPolazak) {
		this.idPolazak = idPolazak;
	}

	public String getVrstaPolaska() {
		return this.vrstaPolaska;
	}

	public void setVrstaPolaska(String vrstaPolaska) {
		this.vrstaPolaska = vrstaPolaska;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}