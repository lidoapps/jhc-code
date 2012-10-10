package cn.jhc.simple.instrument;

import org.springframework.stereotype.Component;

@Component("saxophone")
public class Saxophone implements Instrument {

	public Saxophone() {}
	
	public void play() {
		System.out.println("TOOT TOOT TOOT");
	}

}
