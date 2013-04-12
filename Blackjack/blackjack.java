import java.util.Scanner;
import java.lang.Math;

public class blackjack 
{
	
	public static void main(String[] args)
	{
		int players = 0;
		
		//Title Screen
		Scanner input = new Scanner(System.in);
		System.out.println("*********");
		System.out.println("BLACKJACK");
		System.out.println("*********");
		System.out.println();
		System.out.print("How many players are playing? ");
		players = input.nextInt();
		System.out.println();
		
		//Creates an array to store names of all players
		String[] names = new String[players];
		
		//Gets names from users
		for(int count = 0; count < players; count++)
		{
			System.out.print("Please name player "+(count+1)+": ");
			names[count] = input.next();
		}
		
		System.out.println("Excellent! Type GO to get started!");
		System.out.print("LET'S ");
		String blank = input.next();
		
		//Advances the screen
		for(int count = 0; count < 100; count++)
		{
			System.out.println();
		}
		game.play(players, names);
	}
}
