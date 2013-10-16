package my.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name="findPersonsA", query="SELECT p FROM Person p WHERE p.fullName LIKE 'A%'")

@Entity
public class Person {

	@Id @GeneratedValue
	private Long id;

	private String fullName;
		
	public Long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
