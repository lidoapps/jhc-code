package sample.case2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp2")
public class Employee2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String firstName;
	private String lastName;
	
	@ElementCollection(targetClass=Address.class)
	@CollectionTable(name="address")
	private List<Address> contactAddresses = new ArrayList<Address>();
	
	public Employee2() {}
	
	public Employee2(String firstName, String lastName) {
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

	public List<Address> getContactAddresses() {
		return contactAddresses;
	}

	public void setContactAddresses(ArrayList<Address> contactAddresses) {
		this.contactAddresses = contactAddresses;
	}

	public void addContactAddress(Address address) {
		this.contactAddresses.add(address);
	}

}
