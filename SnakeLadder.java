import java.util.*;
public class SnakeLadder  {
	//Initialize Start Position as Zero
	private int position;
	private int countResult;
	private int winningPosition;
	
	SnakeLadder() {
		this.position = 0;
		this.countResult = 0;
		this.winningPosition = 100;
	}
	
	SnakeLadder(int winningPosition) {
		this.winningPosition=winningPosition;		
	}
		
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
	public void play(String playerName) {
		this.countResult += 1;
		//Rolling a dice
		int resultDice = this.rollDice();
		
		this.setCountResult(this.getCountResult() + 1);
		
		System.out.println("The number on dice is "+resultDice);
		//Getting position for the die 
		int positonPlayer = this.getPosition();
		
		//Calling checkOption function to generate Option	
		int optionResult = this.checkOption();
		
		switch(optionResult){
			//Ladder Position
			case 1 :
				System.out.println("You got a Ladder");
				positonPlayer += resultDice;
				if(positonPlayer > this.getWinningPosition()){
					int numberNeed = this.getWinningPosition() - this.getPosition();
					
					System.out.println("Sorry, You need " + numberNeed + " to Win");
					positonPlayer -= resultDice;
				}
				
				if(positonPlayer == this.getWinningPosition()) {
					this.setPosition(positonPlayer);
					System.out.println("---------Winning Player-------------");
					System.out.println(playerName);
					System.out.println("Hurray You Win, You are at "+this.getPosition());
					System.out.println("The total number of times dice is thrown is "+this.getCountResult());
					System.exit(0);
				}
				this.setPosition(positonPlayer);
				
				System.out.println("The position of the player is "+this.getPosition());
				//If got ladder then calling play function
				this.play(playerName);
				break;
			
			//Snake Position
			case 2:
				System.out.println("You got a Snake");
				positonPlayer -= resultDice;
				
				this.setPosition(positonPlayer);
				
				System.out.println("The position of the player is "+this.getPosition());
				break;
			
			//No Play
			default:
				System.out.println("You got a NoPlay");
				System.out.println("The position of the player is "+this.getPosition());
			}
		}
	
	 /**
	 * @return the winningPosition
	 */
	public int getWinningPosition() {
		return winningPosition;
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
		if(position < 0){
			position = 0;
		}
		this.position = position;
	}
	 /*
	 * 0- No Play
	 * 1-Ladder
	 * 2-Snake
	 */
	public int checkOption(){
	    Random rand = new Random();
		int option = rand.nextInt(3);
		return option;
	} 
	
	public static void main(String[] args) throws InterruptedException {
		//Creating object for SnakeLadder Class
		int numberOfPlayers=2;
		ArrayList<SnakeLadder> playerList = new ArrayList<SnakeLadder>(numberOfPlayers);
		
		for(int i = 0; i < numberOfPlayers; i++) {
			SnakeLadder ObjSnakeLadder = new SnakeLadder();
			playerList.add(ObjSnakeLadder);
		}
		
		while(true) {
			for(int i = 0; i < playerList.size(); i++) {
				int playerNumber = i + 1;
				System.out.println("Game Started for Player "+playerNumber);
				System.out.println();
				playerList.get(i).play("Player "+playerNumber);
			}		
		}
	}
}


