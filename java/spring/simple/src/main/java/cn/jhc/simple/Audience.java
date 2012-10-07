package cn.jhc.simple;

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

}
