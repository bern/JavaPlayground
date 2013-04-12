import java.util.Scanner;
import java.lang.Math;

public class play 
{
	public static Scanner input = new Scanner(System.in);
	public static int max = 0;
	
	//Plays le game
	public static void board(String p1, String p2, int c)
	{
		int x = 0; int y = 0; int turn = 0; int count = 1; int answer = 0; int q = 0; int ans = 0; int t = 0;
		boolean valid = false; boolean p1go = true; boolean p2go = true; boolean go1 = true; boolean go2 = true;
		String poop = "";
		
		//Initializes player's board
		int[][] bo = new int[4][10];
		
		//Initialized path
		int[][] path = pathboard();
		
		//Game plays
		do
		{
			//Sets a holder variable to the current player's turn
			t = turn;
			
			//If p1 got a question wrong
			if(turn == 0 && p1go == false)
			{
				//go1 is the variable that must be true in order for that player to have their turn
				go1 = false;
				
				//We set this to true to that it won't be caught in this if statement again
				p1go = true;
				
				//Now that p1's turn has been skipped, we make it p2's turn!
				turn = 1;
			}
			
			//Same as above
			else if(t == 1 && p2go == false)
			{
				go2 = false;
				p2go = true;
				turn = 0;
			}
			
			//If the turn isn't blocked due to an incorrect question
			else if((turn == 0 && go1 == true) || (turn == 1 && go2 == true))
			{
				if(turn == 1 && go1 == false)
				{
					go1 = true;
				}
				if(turn == 0 && go2 == false)
				{
					go2 = true;
				}
				//Since this is the beginning of the player's turn, the player board is hidden again with 0 and the player must uncover the path starting from 1
			count = 1;
			for(int a = 0; a < 4; a++)
			{
				for(int b = 0; b < 10; b++)
				{
					bo[a][b] = 0;
				}
			}
			
			//This is where the player tries to find the path
		do
		{
			if(valid)
				startquest.advance();
			//I think these both (^ v) are nifty methods to have
		printb(bo);
		if(turn == 0)
			System.out.println("It is "+p1+"\'s turn.");
		else if(turn == 1)
			System.out.println("It is "+p2+"\'s turn.");
		do
		{
			System.out.println("Enter the row and column you would like to travel to.");
			System.out.print("Row: ");
			x = input.nextInt();
			System.out.print("Column: ");
			y = input.nextInt();
			System.out.println();
		}
		//Keeps asking if the cells aren't valid. If the user enters a string, I hate them
		while(x > 4 || x < 1 || y > 10 || y < 1);
		
		//Checks not if the cell entered is on the path, but if the cell entered is at the correct count
		//This lets me check for correct sequence and makes sure the other party doesn't cheat by just entering the goal cell
			if(path[x-1][y-1] == count)
			{
				//If the player uncovers the goal cell
				if(count == max)
				{
					count++;
					break;
				}
				
				//Otherwise, the cell on the player's board is changed to its correct identity
				bo[x-1][y-1] = count;
				count++;
				
				//This makes the loop repeat, so it keeps going until the user enters a wrong cell
				valid = true;
			}
			else
				valid = false;
		}
		//See previous comment
		while(valid);
		
		//n00b
		System.out.println("You chose a space that wasn't within the sequence. Prepare for a question.");
		
		//Chooses the question id
		q = (int)((Math.random()*5)+1);
		//Asks the question
		question.ask(c, q);
		//Sets the answer of the question to int ans
		ans = question.set(c, q);
		System.out.print("Enter the number corresponding to your answer and press the enter key: ");
		answer = input.nextInt();
		if(ans == answer)
			System.out.println("Correct, nice job!");
		else
		{
			System.out.println("Your answer was incorrect, sorry.");
			if(turn == 0)
			{
				//If it's p1's turn, then p1go becomes false so it'll enact the if statement at the top of the outer loop
				System.out.println(p1+"\'s next turn will be skipped.");
				p1go = false;
			}
			if(turn == 1)
			{
				//Same for p2
				System.out.println(p2+"\'s next turn will be skipped.");
				p2go = false;
			}
		}
		//Because I don't know how to use timers...
		System.out.println("Type some gobbledygook and press the enter key to continue.");
		poop = input.next();
			}
			//If you broke out of the inner loop because the goal cell was uncovered...
			if(count == (max + 1))
				//You break out of the outer loop! (Which is infinite otherwise)
				break;
			//Switches the turn
		if(turn == 0)
			turn++;
		else if(turn == 1)
			turn--;
		startquest.advance();
		}
		//TO INFINITY AND BEYOND!
		while(1 == 1);
		startquest.advance();
		//And this is the end of the game!
		System.out.println("The final path has been uncovered!");
		System.out.print("The winner is ");
		if(turn == 0)
			System.out.print(p1);
		else if(turn == 1)
			System.out.print(p2);
		System.out.print("! Congratulations!");
	}
	
	//Creates the path and passes back the answer board (JEENYUS)
	public static int[][] pathboard()
	{
		//Initializing local variables
		int count = 2;
		double x = Math.random();
		int col = 0;
		int ncol = 0;
		int row = 0;
		
		//Generates a random starting place
		int y = (int)(4*x);
		
		//Creates the path board and fills it with 0's
		int[][] pathb = new int[4][10];
		for(int a = 0; a < 4; a++)
		{
			for(int b = 0; b < 10; b++)
				pathb[a][b] = 0;
		}
		row = y;
		
		//Sets the starting place
		pathb[y][0] = 1;
		
		//Creates the path
		do
		{
			//Chooses next column (0 = Same, 1 = Advances)
			x = Math.random();
			y = (int)(2*x);
			ncol = col + y;
			
			//Breaks if the next iteration will cause an o-o-b exception 10
			if(ncol == 10)
				break;
			
			//If the column stays the same
			if(col == ncol)
			{
				//Chooses the row to make the next space in (0 = Up, 1 = Down)
				x = Math.random();
				y = (int)(2*x);
				if(y == 0 && row > 0)
				{
					row--;
					if(pathb[row][ncol] == 0)
					{
						pathb[row][ncol] = (count);
						count++;
						max = count;
					}
					else
						row++;
				}
				else if(y == 1 && row < 3)
				{
					row++;
					if(pathb[row][ncol] == 0)
					{
						pathb[row][ncol] = (count);
						count++;
						max = count;
					}
					else
						row--;
				}
			}
			
			//If the column advances
			else if(col == (ncol-1))
			{
				//Chooses the row to make the next space in (0 = Upright, 1 = Right, 2 = Downright)
				x = Math.random();
				y = (int)(3*x);
				if(y == 0 && row > 0)
				{
					row--;
					if(pathb[row][ncol] == 0)
					{
						pathb[row][ncol] = (count);
						count++;
						max = count;
					}
					else
						row++;
					//upright
				}
				else if(y == 1)
				{
					pathb[row][ncol] = (count);
					count++;
					max = count;
					//right
				}
				else if(y == 2 && row < 3)
				{
					row++;
					if(pathb[row][ncol] == 0)
					{
						pathb[row][ncol] = (count);
						count++;
						max = count;
					}
					else
						row--;
					//downright
				}
				else
					ncol--;
			}
			col = ncol;
		}
		while(col<10);
		
		//Sets the goal value
		max--;
		
		//Returns the path to the board method
		return pathb;
	}
	
	//Prints out a passed board
	public static void printb(int[][] board)
	{
		System.out.println("    1    2    3    4    5    6    7    8    9    10");
		System.out.println("    _______________________________________________");
		for(int a = 0; a < 4; a++)
		{
			System.out.print((a+1)+"  |");
			for(int b = 0; b < 10; b++)
			{
				if(board[a][b] > 9)
				System.out.print(board[a][b] + "   ");
				else
					System.out.print(board[a][b] + "    ");
			}
			System.out.println();
			if(a != 3)
				System.out.println("   |");
		}
	}
}
