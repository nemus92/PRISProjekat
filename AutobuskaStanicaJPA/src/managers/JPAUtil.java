package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityMangerFactory;
	
	static{
		entityMangerFactory = Persistence.createEntityManagerFactory("AutobuskaStanicaJPA");
	}
	
	public static EntityManager getEntityManager(){
		return entityMangerFactory.createEntityManager();
	}
	
}

