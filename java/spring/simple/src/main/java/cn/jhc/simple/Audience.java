package cn.jhc.simple;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	
	//Before performance
	public void takeSeats() {
		System.out.println("The audience is taking their seats.");
	}

	//Before performance
	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}

	//After performance
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	//After bad performance
	public void demandRefund() {
		System.out.println("Boo! We want our money back!");
	}
 
	//Around performance
	public void watchPerformance(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("The audience is taking their seats.");
			System.out.println("The audience is turning off their cellphones.");
			long start = System.currentTimeMillis();
			
			joinPoint.proceed();
			
			long end = System.currentTimeMillis();
			System.out.println("CLAP CLAP CLAP CLAP CLAP");
			System.out.println("The performance took " + (end - start) + " milliseconds.");
		} catch (Throwable e) {
			System.out.println("Boo! We want our money back.");
		}
	}
}
