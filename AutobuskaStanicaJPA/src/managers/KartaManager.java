package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Karta;
import model.Korisnik;

public class KartaManager {
	
	public Integer dodajKartu(EntityManager em, String cenaKarte, String vrstaKarte) {
		try{
			em.getTransaction().begin();
			Karta k = new Karta();
			k.setCenaKarte(cenaKarte);
			k.setVrstaKarte(vrstaKarte);
			em.persist(k);			
			em.getTransaction().commit();
			return k.getIdKarta();		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Karta> getSveSlobodneKarte(EntityManager em) {
		TypedQuery<Karta> tq = em.createQuery("SELECT k FROM Karta k", Karta.class);
		return tq.getResultList();
}
	
	public List<Karta> getCenaKarte(EntityManager em) {
		TypedQuery<Karta> tq = em.createQuery("SELECT k.cenaKarte FROM Karta k", Karta.class);
		return tq.getResultList();
}
	
	public Integer updateKarta(EntityManager em, int idKarta, String cenaKarte) {
			
		Karta k = em.find(Karta.class, idKarta);
		
		try {
		if (k != null) {
			em.getTransaction().begin();
			k.setCenaKarte(cenaKarte);
			em.getTransaction().commit();
			return k.getIdKarta();
		
		} else {
			return null;
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
	Integer k = new KartaManager().dodajKartu(em, "redovna", "1000");
	}
}

