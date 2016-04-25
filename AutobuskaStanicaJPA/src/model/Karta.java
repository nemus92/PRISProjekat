package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the karta database table.
 * 
 */
@Entity
@NamedQuery(name="Karta.findAll", query="SELECT k FROM Karta k")
public class Karta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKarta;

	private String cenaKarte;

	private String vrstaKarte;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="karta")
	private List<Rezervacija> rezervacijas;

	public Karta() {
	}

	public int getIdKarta() {
		return this.idKarta;
	}

	public void setIdKarta(int idKarta) {
		this.idKarta = idKarta;
	}

	public String getCenaKarte() {
		return this.cenaKarte;
	}

	public void setCenaKarte(String cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public String getVrstaKarte() {
		return this.vrstaKarte;
	}

	public void setVrstaKarte(String vrstaKarte) {
		this.vrstaKarte = vrstaKarte;
	}

	public List<Rezervacija> getRezervacijas() {
		return this.rezervacijas;
	}

	public void setRezervacijas(List<Rezervacija> rezervacijas) {
		this.rezervacijas = rezervacijas;
	}

	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		getRezervacijas().add(rezervacija);
		rezervacija.setKarta(this);

		return rezervacija;
	}

	public Rezervacija removeRezervacija(Rezervacija rezervacija) {
		getRezervacijas().remove(rezervacija);
		rezervacija.setKarta(null);

		return rezervacija;
	}

}