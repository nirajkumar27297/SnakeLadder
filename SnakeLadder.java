import java.util.*;
public class SnakeLadder  {
	//Initialize Start Position as Zero
	private int position = 0;
	private int countResult = 0;
		
	/**
	 * @return the countResult
	 */
	public int getCountResult() {
		return countResult;
	}

	/**
	 * @param countResult the countResult to set
	 */
	public void setCountResult(int countResult) {
		this.countResult = countResult;
	}
	
	//Function for rolling a dice
	private int rollDice() {
		Random rand = new Random();
		//generating Random Number from 0 to 5 and adding 1 as LowerLimit
		int resultDice = rand.nextInt(6) + 1;
		return resultDice;
	}
	
	//function for playing game
	public void play(String s) {
		
		
		 
			this.countResult += 1;
			//Rolling a dice
			int resultDice = this.rollDice();
			this.setCountResult(this.getCountResult() + 1);
			System.out.println("The number on dice is "+resultDice);
			//Getting position for the die 
			int pos = this.getPosition();
			//Calling checkOption function to generate Option	
			int optionResult = this.checkOption();
			switch(optionResult)
			{
			    //Ladder Position
				case 1 :
					System.out.println("You got a Ladder");
					pos += resultDice;
					if(pos > 100)
					{
						int numberNeed = 100 - this.getPosition();
						System.out.println("Sorry, You need "+numberNeed+" to Win");
						
					}
					
					if(pos == 100) 
					{
						this.setPosition(pos);
						System.out.println("---------Winning Player-------------");
						System.out.println(s);
						System.out.println("Hurray You Win, You are at "+this.getPosition());
						System.out.println("The total number of times dice is thrown is "+this.getCountResult());
						System.exit(0);
					}
					this.setPosition(pos);
					System.out.println("The position of the player is "+this.getPosition());
					//If got ladder then calling play function
					this.play(s);
					break;
				//Snake Position
				case 2:
					System.out.println("You got a Snake");
					pos -= resultDice;
					this.setPosition(pos);
					System.out.println("The position of the player is "+this.getPosition());
					break;
				//No Play
				default:
					
					System.out.println("You got a NoPlay");
					System.out.println("The position of the player is "+this.getPosition());
			}
		
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
			position = 0;
		}
		this.position = position;
	}
	 //check Option
	/*
	 * 0- No Play
	 * 1-Ladder
	 * 2-Snake
	 */
	public int checkOption(){
	    Random rand = new Random();
		//Generating random numbers in range 0-2
		int option = rand.nextInt(3);
		return option;
	} 
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Creating object for SnakeLadder Class
		
		int n=3;
		ArrayList<SnakeLadder> playerList = new ArrayList<SnakeLadder>(n);
		
		for(int i=0;i<n;i++) {
			SnakeLadder ObjSnakeLadder = new SnakeLadder();
			playerList.add(ObjSnakeLadder);
		}
		while(true) {
			//System.out.println(3);
			for(int i=0;i<playerList.size();i++) {
				
				int playerNumber = i + 1;
				System.out.println("Game Started for Player "+playerNumber);
				System.out.println();
				playerList.get(i).play("Player "+playerNumber);
			}
			
		}

		}
	}


