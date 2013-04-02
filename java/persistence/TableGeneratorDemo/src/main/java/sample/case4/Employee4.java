package sample.case4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="emp4")
public class Employee4 {
	
	@GenericGenerator(
			name="id_gen", 
			strategy="enhanced-table",
			parameters = {
					@Parameter( name = "table_name", value = "enhanced_gen"),
					@Parameter( name = "value_column_name", value = "next"),
					@Parameter( name = "segment_column_name", value = "segment_name"),
					@Parameter( name = "segment_value", value = "emp_seq"),
					@Parameter( name = "increment_size", value = "10"),
					@Parameter( name = "optimizer", value = "pooled-lo")
			})
	@Id
	@GeneratedValue(generator="id_gen")
	private long id;
	
	private String firstName;
	private String lastName;
	
	@ManyToOne
	private Department department = null;
	
	public Employee4() {}
	
	public Employee4(String firstName, String lastName) {
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

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

}
