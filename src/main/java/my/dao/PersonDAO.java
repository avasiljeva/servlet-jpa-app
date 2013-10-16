package my.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import my.domain.Person;

public class PersonDAO {

	private EntityManagerFactory emf;
	
	public PersonDAO(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	public void save(Person person){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(person);
	    em.getTransaction().commit();
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findAll(){
		EntityManager em = emf.createEntityManager();
		List<Person> result = (List<Person>)em.createQuery("SELECT p FROM Person p").getResultList();
		em.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findPersonsA(){
		EntityManager em = emf.createEntityManager();
		Query findAllQuery = em.createNamedQuery("findPersonsA"); 
		List<Person> result = (List<Person>)findAllQuery.getResultList();
		em.close();
		return result;
	}
}
