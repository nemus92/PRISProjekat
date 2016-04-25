package managers;

import java.util.Date;

import javax.persistence.EntityManager;

import model.Karta;
import model.Korisnik;
import model.Rezervacija;

public class RezervacijaManager {

	public Integer rezervisiKartu(EntityManager em, int idKarta, int idKorisnika) {
		try {
			
			Karta karta = em.find(Karta.class, idKarta);

			Korisnik korisnik = em.find(Korisnik.class, idKorisnika);
			
			
			if ((karta != null) && (korisnik != null)) {
				em.getTransaction().begin();
				
				Rezervacija r = new Rezervacija(karta, korisnik, new Date());
				em.persist(r);
				em.getTransaction().commit();
				return r.getIdRezervacija();
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		Integer k = new RezervacijaManager().rezervisiKartu(em, 1, 1);
	}
}
