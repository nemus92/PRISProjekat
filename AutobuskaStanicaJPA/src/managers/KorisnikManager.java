package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Korisnik;

public class KorisnikManager {

	public static Korisnik login(String username, String password) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		//em.getTransaction().begin();
		try {
			
		TypedQuery<Korisnik> tq = em.createQuery("SELECT k FROM Korisnik k WHERE k.userKorisnika = :username "
				+ "AND k.passKorisnika = :password", Korisnik.class);
		tq.setParameter("username", username);	
		tq.setParameter("password", password);
		Korisnik korisnik = tq.getSingleResult();
		return korisnik;
		}catch (NoResultException nre) {
			System.out.println("Nema korisnika");
			return null;
		} catch (Exception ex) {
			System.out.println(" Greska u logovanju");
			ex.printStackTrace();
			if (et.isActive()) {
				et.rollback();
			}
			return null;
	} finally {
		em.close();
	}

}
	public static Korisnik registerKorisnik(String imeKorisnika, String prezimeKorisnika, String adresaKorisnika, String jmbgKorisnika, String userKorisnika,
			String passKorisnika) {

		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			Korisnik k = new Korisnik();
			k.setImeKorisnika(imeKorisnika);
			k.setPrezimeKorisnika(prezimeKorisnika);
			k.setAdresaKorisnika(adresaKorisnika);
			k.setJmbgKorisnika(jmbgKorisnika);
			k.setUserKorisnika(userKorisnika);
			k.setPassKorisnika(passKorisnika);
			em.persist(k);			
			em.getTransaction().commit();
			return k;			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


}


