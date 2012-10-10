package cn.jhc.simple.performer;

import cn.jhc.simple.PerformanceException;
import cn.jhc.simple.poem.Poem;

public class PoeticJuggler extends Juggler {

	private Poem poem;

	public PoeticJuggler() {}
	
	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}
	
	public PoeticJuggler(int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem;
	}
	
	@Override
	public void perform() throws PerformanceException {
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}
}
