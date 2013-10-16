package my.dao;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PersistenceContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		PersonDAO personDAO = new PersonDAO(emf);
		context.setAttribute("personDAO", personDAO);
	}

	public void contextDestroyed(ServletContextEvent event) {
		PersistenceManager.getInstance().closeEntityManagerFactory();
	}
}
