package my.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	private EntityManagerFactory emf;

	private static final PersistenceManager INSTANCE = new PersistenceManager();

	public static PersistenceManager getInstance() {
		return INSTANCE;
	}

	private PersistenceManager() {
	}

	public EntityManagerFactory getEntityManagerFactory() {
		if (emf == null){
			createEntityManagerFactory();
		}
		return emf;
	}

	protected void createEntityManagerFactory() {
		this.emf = Persistence.createEntityManagerFactory("hibernate_mysql");
	}

	public void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}
}
