import java.util.Scanner;
import java.lang.Math;

public class game 
{
	public static Scanner input = new Scanner(System.in);
	public static int value = 0;
	
	public static void play(int p, String[] n)
	{
		//Initializes variables and two more arrays (one to store the players' scores and one to store the winners)
		int win = 0;
		int choice = 0;
		int c = 0;
		boolean hit = true;
		int[] score = new int[p];
		boolean[] w = new boolean[p];
		for(int count = 0; count < p; count++)
			w[count] = false;
		
		//Goes through each player sequentially
		for(int count = 0; count < p; count++)
		{
			hit = true;
			value = 0;
			
			//Deals out the first two cards
			System.out.println(n[count]+"'s turn.");
			int c1 = card.rand();
			value += card.val(c1);
			int c2 = card.rand();
			value += card.val(c2);
			System.out.println("You are dealt a "+card.name(c1)+" and a "+card.name(c2)+".");
			
			//Checks if the cards are aces. If so, the player chooses their value
			acechecker(c1);
			acechecker(c2);
			System.out.println();
			System.out.println("The value of your hand is "+value+".");
			
			//If the player hits, they are dealt another card. If not, their turn ends
			System.out.print("Will you hit (1) or stay (2)? ");
			choice = input.nextInt();
			if(choice==2)
				hit = false;
			else if(choice==1)
			{
			while(hit)
			{
				c = card.rand();
				value += card.val(c);
				System.out.println("You are dealt a "+card.name(c)+".");
				acechecker(c);
				
				//Checks if the player busts
				if(value > 21)
				{
					System.out.println("BUST!");
					System.out.println();
					break;
				}
				System.out.println();
				System.out.println("The value of your hand is "+value+".");
				System.out.print("Will you hit (1) or stay (2)? ");
				choice = input.nextInt();
				if(choice==2)
					hit = false;
			}
			}
			else
				System.out.println("Invalid input. Ending turn.");
			
			//Assigns the value of the player's hand to their slot in the score array
			System.out.println("The final value of "+n[count]+"'s hand is "+value+".");
			score[count] = value;
			System.out.println();
		}
		System.out.println("The game is over!");
		
		//Goes through the score array to find the highest value under 22
		for(int count = 0; count < p; count++)
		{
			if(score[count] < 22 && score[count] > win)
				win = score[count];
		}
		
		//Marks all players who match that value
		for(int count = 0; count < p; count++)
		{
			if(score[count] == win)
				w[count] = true;
		}
		System.out.println("The winners of this game are as follows:");
		
		//Displays the winner
		for(int count = 0; count < p; count++)
		{
			if(w[count])
				System.out.print(n[count]+" ");
		}
		System.out.println();
		System.out.println("CONGRATULATIONS!");
	}
	
	//If the player drew an ace, they choose its value
	public static void acechecker(int id)
	{
		if(id==13)
		{
			System.out.print("Would you like your ace to have a value of 1 (1) or 11 (2)? ");
			int choice = input.nextInt();
			if(choice == 1)
				value += 1;
			else if(choice == 2)
				value += 11;
			else
				value += 1;
		}
	}
}
