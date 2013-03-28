package sample.case3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="emp3")
public class Employee3 {
	
	@TableGenerator(name="id_gen",table="id_gen",initialValue=10)
	@Id	@GeneratedValue(strategy=GenerationType.TABLE,generator="id_gen")
	private long id;
	
	private String firstName;
	private String lastName;
	
	public Employee3() {}
	
	public Employee3(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
