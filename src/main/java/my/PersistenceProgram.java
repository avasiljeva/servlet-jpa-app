package my;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import my.domain.Person;

/**
 * A simple Java program with JPA
 */
public class PersistenceProgram {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_mysql");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Person p = new Person();
		p.setFullName("John White");
		em.persist(p);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
