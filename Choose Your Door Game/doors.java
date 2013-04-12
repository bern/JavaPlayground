import java.util.Scanner;
import java.lang.Math;

public class doors 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int x = 1;
		int door = 0;
		double y = 0;
		int score = 0;
		int choice = 0;
		for(x = 1; x < 100; x++)
		{
			System.out.println("");
			if(x==1)
			{
				System.out.println("There is 1 door in front of you.");
				System.out.print("Type the number of the door to open it. (1) ");
			}
			else
			{
				System.out.println("There are "+x+" doors in front of you.");
				System.out.print("Which do you open? (1-"+x+") ");			
			}	
			y = Math.random();
			if(x > 1)
			door = (int)((y*x)+1);
			else
				door = 1;
			choice = input.nextInt();
			for(int lines = 0; lines < 100; lines++)
				System.out.println("");
			if(choice == door)
			{
				System.out.println("You've chosen the correct door! Congratulations!");
				score++;
				System.out.println("Your score is now "+score+"! Keep going!");
			}
			else
			{
				System.out.println("You've chosen the incorrect door. Oh no!");
				System.out.println("The correct door was "+door+".");
				System.out.print("Your final score was "+score+"! ");
				if(score <= 2)
				{
					System.out.print("You kind of stink at this.");
				}
				if(score > 2 && score <= 4)
				{
					System.out.print("Not bad at all!");
				}
				if(score > 4 && score <= 7)
				{
					System.out.print("Nice job!");
				}
				if(score > 7 && score <= 10)
				{
					System.out.print("JESUS CHRIST.");
				}
				if(score > 10)
				{
					System.out.println("You're a wizard, Harry.");
				}
				break;
			}
			
		}
	}
}
