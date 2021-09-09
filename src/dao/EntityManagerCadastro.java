package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCadastro {

	private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("postgres");
	
	public EntityManager getEntityManager() {

		return entityManagerFactory.createEntityManager();
	}
	
	public void close(EntityManager em) {
		em.close();
	}
	
	
}
