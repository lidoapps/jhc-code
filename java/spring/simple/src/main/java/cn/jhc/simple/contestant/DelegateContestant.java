package cn.jhc.simple.contestant;

public class DelegateContestant implements Contestant {

	@Override
	public void reviewAward() {
		System.out.println("DelegateContestant review award.");
	}

}
