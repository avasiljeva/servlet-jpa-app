package my.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.dao.PersonDAO;
import my.domain.Person;

@SuppressWarnings("serial")
@WebServlet("/person")
public class PersonServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		PersonDAO dao = getDAO(request);

		List<Person> people = dao.findAll();
//		List<Person> people = dao.findPersonsA();
		
		request.setAttribute("people", people);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("person.jsp");
	    dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullName = request.getParameter("full_name");

		Person p = new Person();
		p.setFullName(fullName);
		
		PersonDAO dao = getDAO(request);
		
		dao.save(p);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/person");
	}

	private PersonDAO getDAO(HttpServletRequest request) {
		return (PersonDAO)request.getServletContext().getAttribute("personDAO");
	}
}
