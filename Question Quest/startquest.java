import java.util.Scanner;
import java.lang.Math;

//QuestionQuest - A Competitive Study Game
//Programmed by Bernard Marger
//Concept from Gabriella Squarciafico-Volz
//Creates a 10x4 Board
//Creates some path from col 1 to col 10
//Doesn't go left, downleft, or upleft
//ex. for a board [10][4], a path would be [0][2], [1][2], [2][3], all the way to [9][0, 1, 2, 3].
//make a boolean board, start at a random, and make two randoms - one to set the column for next space [col + 0 or 1] 
//and one to set the row for the next space in the column if[col = col],[row-1 or +1] if[col = col + 1],[row -1, +0, or +1]
//once the path is created, players take turns. They enter a row and column (+1 to actual element).
//if a path piece, they advance
//if not a path piece, a question is asked
//if question is answered correctly, no penalty
//if question is wrong, they are skipped

public class startquest
{
	public static void main(String[] args)
	{
		//Initialization of local variables
		int choice = 0;
		char cnt = ' ';
		String p1, p2, px, con;
		Scanner input = new Scanner(System.in);
		
		//Set selection
		advance();
		System.out.println("Welcome to Question Quest: The Competitive Study Game");
		do
		{
			System.out.println("Which question set would you like to use?");
			setselect();
			System.out.print("Enter the corresponding number of your desired set: ");
			choice = input.nextInt();
			System.out.print("You've chosen ");
			setselect(choice);
			System.out.println("!");
			System.out.print("Will you continue with this choice? (y/n) ");
			con = input.next();
			cnt = con.charAt(0);
			advance();
		}
		while(cnt != 'y' && cnt != 'Y');

		//Player order selection
		System.out.println("Enter the names of both players (Order will be randomly determined).");
		System.out.print("Player 1: ");
		p1 = input.next();
		System.out.print("Player 2: ");
		p2 = input.next();
		System.out.println("\nWelcome "+p1+" and "+p2+"!");
		if(porder() == 0)
		{
			px = p1;
			p1 = p2;
			p2 = px;
		}
		System.out.println("For this game of Question Quest, "+p1+" will go first and "+p2+" will go second.");
		System.out.println("When you are ready to begin, type 'GO' and press the enter key on your keyboard.");
		System.out.print("Let's ");
		con = input.next();
		advance();

		//PLAY (This method is where actual gameplay takes place, lol)
		play.board(p1, p2, choice);		
	}
	
	//Displays sets to choose from
	public static void setselect()
	{
		System.out.println("(1) Chemistry I - Foundations");
		System.out.println("(2) Chemistry I - Enthalpy");
		System.out.println("(3) Chemistry I - Energy");
		System.out.println("(4) Calculus I - Limits");
		System.out.println("(5) Calculus I - Derivatives");
	}

	//User confirms set choice
	public static void setselect(int c)
	{
		switch(c)
		{
			case 1:
			System.out.print("(1) Chemistry I - Foundations");
			break;
			case 2:
			System.out.print("(2) Chemistry I - Enthalpy");
			break;
			case 3: 
			System.out.print("(3) Chemistry I - Energy");
			break;
			case 4: 
			System.out.print("Calculus I - Limits"); 
			break;
			case 5:	
			System.out.print("(5) Calculus I - Derivatives");		
			break;
			default:
			System.out.print("a set that does not exist, sorry"); 
		}
	}

	//Erases the screen (more or less)
	public static void advance()
	{
		int lines = 100;
		for(int x = 0; x < lines; x++)
			System.out.println();
	}

	//Sets player order
	public static int porder()
	{
		double x = Math.random();
		if (x < .5)
			return 0;
		return 1;
	}
}
