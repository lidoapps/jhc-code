package cn.jhc;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@TableGenerator(name="emp_gen",table="id_gen")
	@Id @GeneratedValue(strategy=GenerationType.TABLE,generator="emp_gen")
	private long id;
	
	private String name;
	
	private long salary;
	
	public Employee() {}
	
	public Employee(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (salary ^ (salary >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

}