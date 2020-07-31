import java.util.*;
public class SnakeLadder {
	//Initialize Start Position as Zero
	private int position = 0;
	
	//Function for rolling a dice
	private int rollDice()
	{
		Random rand=new Random();
		//generating Random Number from 0 to 5 and adding 1 as LowerLimit
		int number=rand.nextInt(6)+1;
		return number;
	}
	
	//function for playing game
	public void play()
	{
		System.out.println("Game Started");
		//Rolling a dice
		int number=this.rollDice();
		System.out.println("The number on dice is "+number);
		//Getting position for the die 
		int pos=this.getPosition();
		//Calling checkOption function to generate Option	
		int option=this.checkOption();
		System.out.println("The option is "+option);
		
		//Ladder Position
		if(option == 1)
		{
			pos += number;
			this.setPosition(pos);
		}
		//Snake Position
		else if(option == 2)
		{
			pos -= number;
			this.setPosition(pos);
		}
		System.out.println("The position of the player is "+this.getPosition());
			
	}
	
	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		// If position < 0, then Position is assigned to zero
		if(position < 0)
		{
			position=0;
			
		}
		this.position = position;
	}

	public int checkOption()
	{
	     //check Option
			/*
			 * 0- No Play
			 * 1-Ladder
			 * 2-Snake
			 */
		
		Random rand = new Random();
		//Generating random numbers in range 0-2
		int option=rand.nextInt(3);
		return option;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating object for SnakeLadder Class
		SnakeLadder player1 = new SnakeLadder();
		//Player1 is playing
		player1.play();
	}

}
