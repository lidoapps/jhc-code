package cn.jhc.simple.performer;

import cn.jhc.simple.PerformanceException;
import cn.jhc.simple.instrument.Instrument;

public class Instrumentalist implements Performer{

	private String song;
	private Instrument instrument;
	
	public Instrumentalist() {}
	
	public void perform() throws PerformanceException {
		System.out.println("Playing " + song +" :");
		instrument.play();
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}
	
	public String screamSong() {
		return song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
