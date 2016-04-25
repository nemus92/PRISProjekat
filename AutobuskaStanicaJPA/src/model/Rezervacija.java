package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rezervacija database table.
 * 
 */
@Entity
@NamedQuery(name="Rezervacija.findAll", query="SELECT r FROM Rezervacija r")
public class Rezervacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRezervacija;

	private String brojMesta;

	@Temporal(TemporalType.DATE)
	private Date datumRezervacije;

	//bi-directional many-to-one association to Karta
	@ManyToOne
	private Karta karta;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Rezervacija() {
	}
	
	public Rezervacija(Karta karta, Korisnik korisnik, Date datumRezervacije) {
		this.karta=karta;
		this.korisnik=korisnik;
		this.datumRezervacije=datumRezervacije;
	}

	public int getIdRezervacija() {
		return this.idRezervacija;
	}

	public void setIdRezervacija(int idRezervacija) {
		this.idRezervacija = idRezervacija;
	}

	public String getBrojMesta() {
		return this.brojMesta;
	}

	public void setBrojMesta(String brojMesta) {
		this.brojMesta = brojMesta;
	}

	public Date getDatumRezervacije() {
		return this.datumRezervacije;
	}

	public void setDatumRezervacije(Date datumRezervacije) {
		this.datumRezervacije = datumRezervacije;
	}

	public Karta getKarta() {
		return this.karta;
	}

	public void setKarta(Karta karta) {
		this.karta = karta;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}