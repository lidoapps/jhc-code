package cn.jhc.simple.performer;

import java.util.Collection;

import cn.jhc.simple.PerformanceException;
import cn.jhc.simple.instrument.Instrument;

public class OneManBand implements Performer {

	private Collection<Instrument> instruments;
	
	public OneManBand() {}
	
	public void perform() throws PerformanceException {
		for(Instrument instrument : instruments)
			instrument.play();
	}

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

}
