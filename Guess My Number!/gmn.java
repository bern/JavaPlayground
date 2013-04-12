import java.lang.Math;
import java.util.Scanner;

public class gmn 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int b = 0;
		int guess = 0;
		System.out.println("Welcome to GUESS MY NUMBER!");
		System.out.print("Enter a range between 2 and 10000 for me to choose from! (e.g. if you type 50, I will pick a random number from 1-50) ");
		int x = input.nextInt();
		while((x<2) || (x > 10000))
		{
			System.out.println("That's not a valid number!");
			System.out.print("Try another: ");
			x = input.nextInt();
		}
		int y = (int)((Math.random()*x)+1);
		System.out.println("Alright, I've selected a number from 1-"+x+"!");
		System.out.println("Type go to get to guessing!");
		System.out.print("LET'S ");
		String z = input.nextLine();
		String c = input.nextLine();
		for(int a = 100; a > 0; a--)
			System.out.println();
		while(b != y)
		{
			System.out.print("Guess a number: ");
			b = input.nextInt();
			if(b > y)
				System.out.println("Too high!");
			else if(b < y)
				System.out.println("Too low!");
			System.out.println();
			guess++;
		}
		System.out.println("You guessed it! My number was indeed "+b+"!");
		System.out.println("It took you "+guess+" guesses. See if you can do better next time!");
	}
}
