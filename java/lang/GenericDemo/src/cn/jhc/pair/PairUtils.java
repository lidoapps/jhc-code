package cn.jhc.pair;

public class PairUtils {

	public static boolean hasNulls(Pair<?> p) {
		return p.getFirst() == null || p.getSecond() == null;
	}
	
	public static <T> void swapHelper(Pair<T> p) {
		T t = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
	
	public static void swap(Pair<?> p) {
		swapHelper(p);
	}
	
	public static void printBuddies(Pair<? extends Employee> p) {
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
	}
	
	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
		if(a == null || a.length == 0) return;
		Manager min = a[0];
		Manager max = a[0];
		for (int i = 0; i < a.length; i++) {
			if(min.getBonus() > a[i].getBonus())
				min = a[i];
			if(max.getBonus() < a[i].getBonus())
				max = a[i];
		}
		result.setFirst(min);
		result.setSecond(max);
	}
	
	public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
		minmaxBonus(a, result);
		swap(result);
	}
}
