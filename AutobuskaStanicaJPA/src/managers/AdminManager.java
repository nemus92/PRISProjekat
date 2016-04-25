package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Admin;


public class AdminManager {

	public static Admin login(String username, String password) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		//em.getTransaction().begin();
		try {
			
		TypedQuery<Admin> tq = em.createQuery("SELECT a FROM Admin a WHERE a.userAdmin = :username "
				+ "AND a.passAdmin = :password", Admin.class);
		tq.setParameter("username", username);	
		tq.setParameter("password", password);
		Admin admin = tq.getSingleResult();
		return admin;
		}catch (NoResultException nre) {
			System.out.println("Nema admina");
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
	
	public Integer registerAdmin(EntityManager em, String userAdmin, String passAdmin) {
		try{
			em.getTransaction().begin();
			Admin a = new Admin();
			a.setUserAdmin(userAdmin);
			a.setPassAdmin(passAdmin);
			em.persist(a);			
			em.getTransaction().commit();
			return a.getIdAdmin();		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		Integer a = new AdminManager().registerAdmin(em, "admin", "admin");
	}
}
