package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@Table(name="korisnik")
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String adresaKorisnika;

	private String imeKorisnika;

	private String jmbgKorisnika;

	private String passKorisnika;

	private String prezimeKorisnika;

	private String userKorisnika;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="korisnik")
	private List<Rezervacija> rezervacijas;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getAdresaKorisnika() {
		return this.adresaKorisnika;
	}

	public void setAdresaKorisnika(String adresaKorisnika) {
		this.adresaKorisnika = adresaKorisnika;
	}

	public String getImeKorisnika() {
		return this.imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public String getJmbgKorisnika() {
		return this.jmbgKorisnika;
	}

	public void setJmbgKorisnika(String jmbgKorisnika) {
		this.jmbgKorisnika = jmbgKorisnika;
	}

	public String getPassKorisnika() {
		return this.passKorisnika;
	}

	public void setPassKorisnika(String passKorisnika) {
		this.passKorisnika = passKorisnika;
	}

	public String getPrezimeKorisnika() {
		return this.prezimeKorisnika;
	}

	public void setPrezimeKorisnika(String prezimeKorisnika) {
		this.prezimeKorisnika = prezimeKorisnika;
	}

	public String getUserKorisnika() {
		return this.userKorisnika;
	}

	public void setUserKorisnika(String userKorisnika) {
		this.userKorisnika = userKorisnika;
	}

	public List<Rezervacija> getRezervacijas() {
		return this.rezervacijas;
	}

	public void setRezervacijas(List<Rezervacija> rezervacijas) {
		this.rezervacijas = rezervacijas;
	}

	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		getRezervacijas().add(rezervacija);
		rezervacija.setKorisnik(this);

		return rezervacija;
	}

	public Rezervacija removeRezervacija(Rezervacija rezervacija) {
		getRezervacijas().remove(rezervacija);
		rezervacija.setKorisnik(null);

		return rezervacija;
	}

}