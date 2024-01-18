
public class Wallet {
	String name;
	int money;
	
	public int sellT1() {
		this.money += 100;
		return money;
	}
	
	public int sellT2() {
		this.money += 5000;
		return money;
	}
	
	public int sellT3() {
		this.money += 10000;
		return money;
	}
	
}

