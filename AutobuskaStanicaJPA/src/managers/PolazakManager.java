package managers;

import javax.persistence.EntityManager;

import model.Polazak;


public class PolazakManager {
	
	public Integer dodajPolazak(EntityManager em, String vrstaPolaska) {
		try{
			em.getTransaction().begin();
			Polazak p = new Polazak();
			p.setVrstaPolaska(vrstaPolaska);
			em.persist(p);			
			em.getTransaction().commit();
			return p.getIdPolazak();			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	

}
