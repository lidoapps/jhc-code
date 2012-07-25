package cn.jhc.pair;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private String name;
	private double salary;
	private Date hireDate;
	
	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		hireDate = calendar.getTime();
	}

	public void raiseSalary(double byPercent) {
		salary += salary * byPercent / 100;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDate() {
		return hireDate;
	}
}
