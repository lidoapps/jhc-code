package cn.jhc.simple.instrument;

import org.springframework.stereotype.Component;

@Component("piano")
public class Piano implements Instrument {

	public Piano() {}
	
	public void play() {
		System.out.println("PLINK PLINK PLINK");
	}

}
