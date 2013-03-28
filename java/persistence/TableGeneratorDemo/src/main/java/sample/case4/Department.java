package sample.case4;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="dept")
public class Department {

	@GenericGenerator(
			name="id_gen", 
			strategy="enhanced-table",
			parameters = {
					@Parameter( name = "table_name", value = "enhanced_gen"),
					@Parameter( name = "value_column_name", value = "next"),
					@Parameter( name = "segment_column_name", value = "segment_name"),
					@Parameter( name = "segment_value", value = "dept_seq"),
					@Parameter( name = "increment_size", value = "20"),
					@Parameter( name = "optimizer", value = "pooled")
			})
	@Id
	@GeneratedValue(generator="id_gen")
	private int id;
	private String name;
	
	@OneToMany(mappedBy="department",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private Collection<Employee4> employees = new ArrayList<Employee4>();
	public Department() {}

	public Department(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee4> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee4> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee4 employee) {
		employees.add(employee);
		employee.setDepartment(this);
	}

}
