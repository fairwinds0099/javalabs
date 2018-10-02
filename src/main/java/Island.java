package chapter7;

import java.util.Scanner;

/**
 * This program is to simulate cabbage, goat, traveler, and wolf game. 
 * 
 * It is a basic implementation of Graph Theory in Discrete Math.
 * 
 * @author : Mehmet Acikgoz
 * @date   : September 18, 2018
 */

public class Island {
	final int SIZE = 4;	
	private static int numMove;
	
	private int [] data;	
	
	/**
	 * Prompts for the menu of the game and returns the users choice as long as it is within the boundary (1 and 4). 
	 * If not, it keeps on asking the same question 
	 * @param input is the Scanner object just to get a reply from the user.
	 * @return user's choice. 
	 */

	public static char menu(Scanner input) {
		char choice;

		do {
			System.out.println("1. move CABBAGE and TRAVELLER"); 
			System.out.println("2. move GOAT and TRAVELLER"); 
			System.out.println("3. move TRAVELLER ONLY");
			System.out.println("4. move WOLF and TRAVELLER");
			System.out.print(">> ");
			choice = input.next().charAt(0);
			if ( !(choice >= '1' && choice <= '4') )
				System.out.println("Invalid input. Try again.");
		} while (!(choice >= '1' && choice <= '4'));

		return choice;		
	}
	
	public static int getnumMove() {
		return numMove;
	}
	
	public Island() {
		data = new int[SIZE];
	}
	
	public Island(int cabbage, int goat, int traveller, int wolf) {
		this();		
		data[0] = cabbage;
		data[1] = goat;
		data[2] = traveller;
		data[3] = wolf;		
	}
	
	public void setElement(int index, int val) {
		data[index] =  val;
	}
	
	public int getElement(int index) {
		return data[index];
	}
	
	
	@Override
	public String toString() {
		String result ="";
		for (int i = 0; i < data.length ; i++) {			
			switch(i) {
				case 0: 
					result  = (getElement(i) == 1) ? "C ":"  ";
					break;
				case 1:
					result += (getElement(i) == 1) ? "G ":"  ";
					break;
				case 2:
					result += (getElement(i) == 1) ? "T ":"  ";
					break;
				case 3:
					result += (getElement(i) == 1) ? "W ":"  ";
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}
		return result;
	}
	
	/**
	 * Prints the possessions status to the console.
	 */
	public void print() {
		for ( int element : data ) {
			System.out.print( element +" ");
		}
	}
	
	/**
	 * Moves the possession from an island to the other one. 
	 * If successfull, returns true otherwise false (in case of illegal move). 
	 * @param choice is the given movement type for moving possessions in pair or single 
	 * @param islandTo is the island that the possessions are moved to.
	 * @return true if movement type is legitimate otherwise false.  
	 */
	
	public boolean moveObject(int choice, Island islandTo) {
		boolean isMoved = false;
		if (choice == 1 && this.getElement(0) == 1 && this.getElement(2) == 1) { 
				this.setElement(0, 0);
				this.setElement(2, 0);
				islandTo.setElement(0, 1);
				islandTo.setElement(2, 1);			
				isMoved = true;
		} else if (choice == 2 && this.getElement(1) == 1 && this.getElement(2) == 1) {
				this.setElement(1, 0);
				this.setElement(2, 0);
				islandTo.setElement(1, 1);
				islandTo.setElement(2, 1);		
				isMoved = true;
		} else if (choice == 3 && this.getElement(2) == 1 ) {
				this.setElement(2, 0);
				islandTo.setElement(2, 1);
				isMoved = true;
		} else if (choice  == 4 && this.getElement(2) == 1 && this.getElement(3) == 1){
				this.setElement(2, 0);
				this.setElement(3, 0);
				islandTo.setElement(2, 1);
				islandTo.setElement(3, 1);		
				isMoved = true;
		} else   
			System.out.println("Illegal move. Try again.");		
		
		if (isMoved)
			numMove++;
		
		return isMoved;
	}
	
	
	/**
	 * Checks the win situation
	 * 
	 * @return true if you win otherwise false.
	 */	
	boolean checkWin() {		
		for (int element: this.data) { 
			if (element == 0)
				return false;
		}		
		return true;
	}
	
	/**
	 * Checks the lose situation 
	 * @return true if you lose otherwise true.
	 */
	
	boolean checkLose() {
		if (this.getElement(0) == 1 && this.getElement(1) == 1 && this.getElement(2) == 0 && this.getElement(3) == 1) {
			System.out.println("Goat eats cabbage and then wolf eats the goat.");			
			return true;
		}
		else if (this.getElement(0) == 1 && this.getElement(1) == 1 && this.getElement(2) == 0) {
			System.out.println("Goat eats cabbage.");
			return true;
		}
		else if (this.getElement(1) == 1 && this.getElement(3) == 1 && this.getElement(2) == 0) {
			System.out.println("Wolf eats goat.");
			return true;
		}
		else
			return false;		
	}
	
	/**
	 * Prints on the console the current status on the islands 
	 * @param island1 is the island where all the possessions are initially located.  
	 * @param island2 is the island where the possessions are to be moved to.
	 */	
	public static void getStatus(Island island1, Island island2) {
		System.out.println("\n");
		System.out.println(" "+island1+"\t\t\t"+ island2);
		System.out.println("========="+"\t\t\t"+ "=========");
		System.out.println(" island1 "+"\t\t\t"+ " island2 ");

		System.out.println("\n");		
		
	}
	
	/**
	 * Asks about whether you want to try again or not.
	 * @param input is sent to get a reply back from the console.
	 * @returns true if you want to retry otherwise false.
	 */
	
	public static boolean newGame(Scanner input) {
		System.out.print("Do you want to retry? [Y/N]: ");
		char ch = input.next().toUpperCase().charAt(0);
		return (ch == 'Y') ? true:false;		
	}
	
	/**
	 * This part tells about the rules of the game.
	 * 
	 */	
	public static void tellStory() {
		System.out.println("\t\tCabbage(C), Goat(G), Traveller(T) and Wolf(W)");
		System.out.println("A traveler (T) has three possessions : a wolf (W), a goat (G), and a cabbage (C). He must\ntransport them across a river.\n");
		System.out.println("The catch is that, if left alone, the wolf will eat the goat, or the goat will eat\nthe cabbage.The boat can only hold the traveller and one possession at a time." );
		System.out.println("\nHow do you think traveller can transport his possesions from ISLAND1 to ISLAND2 safely?\n\nLet's Start!");
	}



	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
		boolean isnewGame = false;
		
		do {
			tellStory();
			Island island1 = new Island(1, 1, 1, 1);
			Island island2 = new Island();
			boolean isGameOver = false;
	
			System.out.println("YOU'RE HERE");
			getStatus(island1, island2);
		
			while ( !isGameOver ) {
				
				int moveType = menu(input) - '0'; // casting to int
	
				if (getnumMove() % 2 == 0) {
					if ( island1.moveObject(moveType, island2) )
						System.out.println("\t\t\t\tYOU'RE HERE");
					else 
						System.out.println("YOU'RE HERE");
				}
				else {
					if ( island2.moveObject(moveType, island1) )
						System.out.println("YOU'RE HERE");
					else
						System.out.println("\t\t\t\tYOU'RE HERE");
				}
	
				getStatus(island1, island2);
	
				if (island2.checkLose() || island1.checkLose()) {
					System.out.println("GAME OVER!" );
					isGameOver = true;
					isnewGame = newGame(input);
				}
				else if (island2.checkWin()) {
					System.out.println("YOU WIN!");
					isGameOver = true;
					isnewGame = newGame(input);
	
				}
				
	
				
				if (isGameOver && isnewGame) {
					numMove = 0;
				}
				
			} // while	block	
		} while (isnewGame); // do block
		input.close();
		System.out.println("\nBye...");

	}


}
