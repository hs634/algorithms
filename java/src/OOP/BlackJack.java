package OOP;

public class BlackJack extends Card{

	public BlackJack(int r, Suit s) {
		super(r, s);
	}
	
	public int value(){
		int r = super.value();
		if(r==1){
			return 11;
		}
		if(r < 10) return r;
		return 10;
	}
	
	boolean isAce(){
		return super.value() == 1;
	}

}
