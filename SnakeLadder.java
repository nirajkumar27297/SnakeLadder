import java.util.*;
public class SnakeLadder {
	//Initialize Start Position as Zero
	private int position = 0;
	
	//Function for rolling a dice
	public int rollDice()
	{
		Random rand=new Random();
		//generating Random Number from 0 to 5 and adding 1 as LowerLimit
		int number=rand.nextInt(6)+1;
		return number;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeLadder player1 = new SnakeLadder();
		System.out.println(player1.rollDice());
	}

}