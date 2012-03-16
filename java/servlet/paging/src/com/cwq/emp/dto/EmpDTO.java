package com.cwq.emp.dto;

import java.util.Date;

public class EmpDTO {
	private String empno;
	private String ename;
	private String job;
	private String hiredate;
	private float sal;
    
	
	public EmpDTO(String empno, String ename, String job, String hiredate,
			float sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.sal = sal;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	

}
