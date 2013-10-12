import java.util.Scanner;
import java.lang.Math;

public class montyhall {
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		
		do {
		
			System.out.println("Welcome to the Monty Hall problem simulator!");
			System.out.println("What would you like to do?");
			//System.out.println("1. Play the game");
			System.out.println("0. What is the Monty Hall problem?");
			System.out.println("1. Simulate with staying");
			System.out.println("2. Simulate with switching");
			System.out.println("3. Quit");
			System.out.print("Your choice: ");
			int choice = in.nextInt();
			System.out.println();
			
			switch(choice) {
				case 0:
					System.out.println("[Excerpt from Wikipedia]\nThe Monty Hall problem is a probability puzzle, loosely based on the \nAmerican television game show Let's Make a Deal and named after its \noriginal host, Monty Hall. The problem was originally \nposed in a letter by Steve Selvin to the American Statistician in 1975. \nSuppose you're on a game show, and you're given the choice of three doors: \nBehind one door is a car; behind the others, goats. \nYou pick a door, say No. 1, and the host, who knows what's behind the doors, \nopens another door, say No. 3, which has a goat. He then says to you, \n\"Do you want to pick door No. 2?\" Is it to your advantage to switch your choice?\nThis simulator runs the Monty Hall problem a specified number of times, \nwith the options being that the simulation switches its door or stays with its original choice.\n");
					break;
				case 1:
					sim(1);
					break;
				case 2:
					sim(2);
					break;
				case 3:
					quit = true;
					break;
				default:
					System.out.println("Invalid choice.\n");
			}
			
		} while (!quit);
	}
	
	public static void sim(int option) {
		Scanner in = new Scanner(System.in);
		int numSim;
		int wins = 0;
		double winPercent = 0;
		int doorChoice;
		int car;
		int rndDoor;
		int[] doors = new int[3];
		int[] newDoors = new int[2];
		boolean show = false;
		
		System.out.print("How many simulations would you like to run? ");
		numSim = in.nextInt();
		System.out.print("Would you like to show results for each simulation? Y/N ");
		String showres = in.next();
		if(showres.toLowerCase().equals("y")) show = true;
		System.out.println();
		
		for(int i = 1; i <= numSim; i++) {
		
			//Simulator selects winning door and chosen door
			car = ((int)(Math.random()*3));
			doorChoice = ((int)(Math.random()*3));
			if(show) {
				System.out.println("Door "+(doorChoice+1)+" was chosen.");
				System.out.println("Correct door is "+(car+1)+".");
			}
			
			if(option == 2) {			
				//SWITCHING SCENARIO
				
				//Populates a three-element array [0][1][0] with a 1 appearing at the winning door
				for(int j = 0; j < doors.length; j++) {
					if((j) == car)
						doors[j] = 1;
					else
						doors[j] = 0;
				}
				
				//Cuts down array size to two by eliminating the chosen door
				//No need to store whether or not the initially chosen door was the winning one since we're switching regardless
				if(doorChoice == 0) {
					newDoors[0] = doors[1]; newDoors[1] = doors[2];
				}
				else if(doorChoice == 1) {
					newDoors[0] = doors[0]; newDoors[1] = doors[2];
				}
				else {
					newDoors[0] = doors[0]; newDoors[1] = doors[1];
				}
				
				boolean goodstuff = false;
				
				//Eliminate one of the goats (0's) from the cut-down array, leaving one choice available
				while(!goodstuff) {
					rndDoor = (int)(Math.random()*2);
					if(newDoors[rndDoor] == 0 ) {
						newDoors[rndDoor] = 9;
						goodstuff = true;
					}				
				}
				
				if(show) {
					System.out.print("One false door was eliminated. \nRemaining door is a ");
				}
				
				if(show) {
					for(int a = 0; a < newDoors.length; a++) {
						if(newDoors[a]!=9) System.out.print(newDoors[a]+".\n");
					}
				}
				
				int trueIndex = 0;
				
				//Select the only valid index
				for(int k = 0; k < newDoors.length; k++) {
					if (newDoors[k] == 9)
						continue;
					else trueIndex = k;
				}
				
				if(show) {
					System.out.println("Switched value to that remaining door.");
				}
				
				//66% chance of it being a 1
				if(newDoors[trueIndex] == 1) {
					if(show) {
						System.out.println("Simulator WINS.\n");
					}
					
						wins++;
				}
				else { if(show) {
					System.out.println("Simulator LOSES.\n");
					}
				}
			}
			
			else if(option == 1) {
				//If you stay, then nothing else really goes into this
				//Since you hold your original choice, you just have a flat 33% chance of succeeding
				if(show) {
					System.out.println("Comparing door chosen to correct door.");
				}
				
				if(car == doorChoice) {
					if(show) {
						System.out.println("Simulator WINS.\n");
					}
					wins++;
				}
				else { if(show) { 
					System.out.println("Simulator LOSES.\n");
					}
				}
			}
			
			winPercent = (double)wins/(double)i;
			
		}
		System.out.println("The simulator was successful "+(winPercent*100)+"% of the time.\n");
	}
}
