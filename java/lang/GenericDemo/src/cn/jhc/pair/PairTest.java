package cn.jhc.pair;

import static cn.jhc.pair.PairUtils.*;
import org.junit.Test;

public class PairTest {

	@Test
	public void testPair() {
		Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
		Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
		Pair<Manager> buddies = new Pair<Manager>(ceo, cfo);
		printBuddies(buddies);
		ceo.setBonus(1000000);
		cfo.setBonus(500000);
		Manager[] managers = { ceo, cfo };
		Pair<Employee> result = new Pair<Employee>();
		minmaxBonus(managers, result);
		System.out.println("first: " + result.getFirst().getName()
				+ ", second: " + result.getSecond().getName());
		maxminBonus(managers, result);
		System.out.println("first: " + result.getFirst().getName()
				+ ", second: " + result.getSecond().getName());
	}
}
