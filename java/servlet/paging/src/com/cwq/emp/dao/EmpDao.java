package com.cwq.emp.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cwq.emp.dto.EmpDTO;
import com.cwq.emp.dto.Page;


public class EmpDao {
	/*
	 * return user items count
	 */
	static int count=0;
	static ArrayList<EmpDTO> emps=null;
	public static int getCount(Connection conn) {
		String strSql="select count(empno) from emp";
		ResultSet rs=null;
		//int count=0;
	    Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strSql);
			if(!rs.next()) {
				return 0;
			} else {
				count = rs.getInt(1);
			}
			stmt.close();
		} catch(Exception ex) {
			System.err.println("DBConnection.getCount(): " + ex.getMessage());
		}

		return count;
	}
	/*
	 * return totalPage
	 */
	public static int getTotalpage(int pagesize){
		return (count+pagesize-1)/pagesize;
	}
	/*
	 * paging emps
	 */
	public static ArrayList<EmpDTO> getPagingEmps(Connection conn, 
			String pageno, int pagesize) throws Exception {
		String strSql="select empno,ename,hiredate,job,sal from emp";
		emps=new ArrayList<EmpDTO>();
		ResultSet rs=null;
	    Statement stmt = null;
		int page=Integer.parseInt(pageno);
		//int count=getCount();
		int totalpage=getTotalpage(pagesize);
		int start=(page-1)*pagesize;
		int j=0;
		if (count==0){
			return null;
		}
		if (page>totalpage){
			page=totalpage;
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strSql);
			for (int i=0;i<start;i++){
				rs.next();
			}
			while (rs.next() && j<pagesize){
				emps.add(new EmpDTO(rs.getString("empno"),rs.getString("ename"),
						rs.getString("job"),rs.getString("hiredate"),rs.getFloat("sal")));
				j++;	
			}	
		}catch (Exception ex) {
			System.err.println("DBConnection.getCount(): " + ex.getMessage());
		}
		return emps;
	}
	public  static List<Page> getPages(String pageno,int pagesize){
		List<Page> pages=new ArrayList<Page>();
		for (int i=1;i<=getTotalpage(pagesize);i++){
			Page page=new Page();
			page.setPageno(String.valueOf(i));
			if (pageno.equals(String.valueOf(i))){
				page.setFlag(1);
			}else{
				page.setFlag(0);
			}
			pages.add(page);
		
		}
		return pages;
	}
	

}
