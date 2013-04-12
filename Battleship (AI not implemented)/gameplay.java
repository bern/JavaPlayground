import java.util.Scanner;
import java.io.*;
import java.lang.*;

public class gameplay
{
	public static Scanner input = new Scanner(System.in);
	
	public static void play(int[][] pBoard, int[][] cBoard)
	{
		String filler;
		boolean out = false;
		int turn = 1;
		// 1 = player, 0 = computer
		do
		{
			switch(turn)
			{
			case 1:
				playerturn(cBoard);
				if(checkBoardWiped(cBoard))
					out = true;
				turn--;
				System.out.println("Type GO to go to the computer's turn.");
				System.out.print("COMPUTER ");
				filler = input.next();
				battleship.advance();
			case 0:
				compturn(pBoard);
				if(checkBoardWiped(pBoard))
					out = true;
				turn++;
				System.out.println("Type GO to go to your turn.");
				System.out.print("LET'S ");
				filler = input.next();
				battleship.advance();
				break;
			}
		}
		while(!out);
		
		System.out.println("THE GAME IS OVER!");
		System.out.print("This game's winner is ");
		if(turn == 1)
			System.out.println("the computer :(");
		else
			System.out.println("you! :)");
	}
	
	public static void playerturn(int[][] c)
	{
		int row = 0;
		int col = 0;
		boolean good = true;
		String cell;
		battleship.line();
		System.out.println("Your turn!");
		System.out.println("The enemy's board is as follows:");
		player.printBoard(c);
		battleship.line();
		do
		{
		battleship.line();
		System.out.print("Enter a cell to attack: ");
		cell = input.next();
		if(player.isValid(cell))
		{
			row = player.convertLetter(cell);
			System.out.print("("+row+",");
			col = player.convertNumber(cell);
			System.out.println(col+")");
		}
			if((!player.isValid(cell))||(row > 9)||(col > 9))
			{
				good = false;
				battleship.line();
				System.out.println("Invalid cell, try again.");
			}
			else if(c[row][col] == -1||c[row][col] == -2)
			{
				battleship.line();
				good = false;
				System.out.println("You've already hit that space!");
			}
			else
				good = true;
		}
		while(!good);
		if(c[row][col] == 0)
		{
			battleship.line();
			System.out.println("Miss...");
			c[row][col] = -2;
		}
		else
		{
			battleship.line();
			System.out.println("HIT!!!");
			c[row][col] = -1;
		}
		battleship.line();
		System.out.println("The computer's board is now: ");
		player.printBoard(c);
		battleship.line();
	}
	
		public static void compturn(int[][] p)
	{
		int row = (int)(Math.random()*10);
		int col = (int)(Math.random()*10);
		while(p[row][col] == -1||p[row][col] == -2)
		{
			row = (int)(Math.random()*10);
			col = (int)(Math.random()*10);
		}
		
		if(p[row][col] == 0)
		{
			battleship.line();
			System.out.println("The computer MISSED.");
			p[row][col] = -2;
		}
		else
		{
			battleship.line();
			System.out.println("The computer HIT.");
			p[row][col] = -1;
		}
		battleship.line();
		System.out.println("Your board is now:");
		player.printBoard(p);
		battleship.line();
	}
	
	public static boolean checkBoardWiped(int[][] board)
	{
		for(int x = 0; x < board.length; x++)
		{
			for(int y = 0; y < board.length; y++)
			{
				if(board[x][y] != 0 || board[x][y] != -1 || board[x][y] != -2)
					return false;
			}
		}
		return true;
	}
}