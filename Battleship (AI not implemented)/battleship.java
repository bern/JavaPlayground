/*
BATTLESHIP
create 10x10 grid
5 ships types
aircraft carrier - 5	battleship - 4		submarine - 3
cruiser - 3		destroyer - 2
Always player vs. AI
Player selects where ships are placed
*/

import java.util.Scanner;

public class battleship
{
	
	//Initialize the player's board to start
	public static int[][] pBoard = new int[10][10];
	public static Scanner input = new Scanner(System.in);
	public static String filler = "";

	public static void main(String[] args)
	{
		System.out.println("WELCOME TO");
		System.out.println("**BATTLESHIP: JAVA EDITION**");
		line();
		System.out.println("For this version, only Player vs. AI is supported. Sorry!");
		System.out.println("Type 'GO' to get started.");
		line();
		System.out.print("LET'S ");
		filler = input.next();
		advance();
		
		player.fillBoard(pBoard);
	}
	
	public static void line()
	{
		System.out.println();
	}
	
	public static void advance()
	{
		for(int x = 0; x < 100; x++)
		{
			line();
		}
	}
}