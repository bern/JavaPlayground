import java.util.Scanner;
import java.io.*;
import java.lang.*;

public class player
{
	public static void fillBoard(int[][] pBoard)
	{
		Scanner input = new Scanner(System.in);
		String orient;
		String shipCell;
	
		String place;
		boolean allDone = false;
		boolean already = true;
		boolean dne = true;
		boolean validCell = true;
		boolean validGrid = true;
		
		// 5
		boolean ac = true;
		
		// 4
		boolean bship = true;
		
		// 3
		boolean sub = true;
		boolean cruise = true;
		
		// 2
		boolean dest = true;
		
		while(!allDone)
		{
			System.out.println("Your current board is: ");
			battleship.line();
			printBoard(pBoard);
			
			do
			{
				battleship.line();
				System.out.println("Your current ships available are");
				showShips(ac, bship, sub, cruise, dest);
				
				battleship.line();
				System.out.print("Which ship will you place? (Enter the corresponding capital letter) ");
				
				place = input.next();
				
				//false means it HAS been placed
				already = alreadyPlaced(place, ac, bship, sub, cruise, dest);
				
				//false means it's an invalid input
				dne = doesntEx(place);
				
				battleship.line();
				if(!already)
					System.out.println("That ship has already been placed!");
				if(!dne)
					System.out.println("That is not a valid ship identifier!");
			}
			while(!already||!dne);
			
			System.out.print("You are placing the ");
			shipName(place);
			System.out.println(".");
			System.out.println("This ship will take up "+shipSpace(place)+" cells.");
			
			battleship.line();
			do
			{
				System.out.println("Which direction will you orient the ship? (V)ertically or (H)orizontally ");
				orient = input.next();
				if(!orient.equals("V")&&!orient.equals("H"))
				{
					battleship.line();
					System.out.println("Invalid orientation!");
				}
				battleship.line();
			}
			while(!orient.equals("V")&&!orient.equals("H"));
			
			System.out.print("You've chosen to have a ");
			switch(orient)
			{
				case "V":
					System.out.println("vertical orientation.");
					System.out.println("Starting from the cell you select, your ship will extend "+shipSpace(place)+" cells downwards.");
					break;
				case "H":
					System.out.println("horizontal orientation.");
					System.out.println("Starting from the cell you select, your ship will extend "+shipSpace(place)+" cells to the right.");
					break;
				default:
					break;
			}
			
			do
			{
			do
			{
				validCell = true;
				battleship.line();
				System.out.print("Which cell will you place this ship on? (letternumber, e.g. A1) ");
				shipCell = input.next();
				validCell = isValid(shipCell);
				validGrid = isOnGrid(shipCell, pBoard, orient, place);
				if(!validCell||!validGrid)
					System.out.println("That cell is not valid.");
			}
			while(!validCell);
			}
			while(!validGrid);
			
			placeShip(shipCell, pBoard, orient, place);
			
			switch(place)
			{
				case "A":
					ac = false;
					break;
				case "B":
					bship = false;
					break;
				case "S":
					sub = false;
					break;
				case "C":
					cruise = false;
					break;
				case "D":
					dest = false;
					break;
			}
			
			if(!ac&&!bship&&!sub&&!cruise&&!dest)
			{
				allDone = true;
			}
		}
		
		battleship.advance();
		
		System.out.println("Your final board is:");
		printBoard(pBoard);

		int[][] cBoard = fillComputerBoard();
		battleship.line();
		System.out.println("Type GO to continue!");
		System.out.print("LET'S ");
		String filler = input.next();
		battleship.advance();
		gameplay.play(pBoard, cBoard);
	}
	
	public static int[][] fillComputerBoard()
	{
		int[][] cBoard = new int[10][10];
		for(int x = 0; x < cBoard.length; x++)
		{
			for(int y = 0; y < cBoard.length; y++)
			{
				cBoard[x][y] = 0;
			}
		}
		
		fill(cBoard, "A");
		fill(cBoard, "B");
		fill(cBoard, "S");
		fill(cBoard, "C");
		fill(cBoard, "D");
		return cBoard;
	}
	
	public static void fill(int[][] cBoard, String x)
	{
		double rand = Math.random();
		int row = (int)((Math.random()*10));
		int col = (int)((Math.random()*10));
		int orient = 1;
		if(rand < .5)
			orient = 1;
		else
			orient = -1;
		switch(x)
		{
			case "A":
				while(!checkCell(cBoard, orient, x, row, col))
				{
					row = (int)((Math.random()*9));
					col = (int)((Math.random()*9));
				}
				for(int i = 0; i < shipSpace(x); i++)
				{
					if(orient == 1)
						cBoard[row+i][col] = 1;
					else if(orient == -1)
						cBoard[row][col+i] = 1;
				}
				break;
			case "B":
				while(!checkCell(cBoard, orient, x, row, col))
				{
					row = (int)((Math.random()*9));
					col = (int)((Math.random()*9));
				}
				for(int i = 0; i < shipSpace(x); i++)
				{
					if(orient == 1)
						cBoard[row+i][col] = 2;
					else if(orient == -1)
						cBoard[row][col+i] = 2;
				}
				break;
			case "S":
				while(!checkCell(cBoard, orient, x, row, col))
				{
					row = (int)((Math.random()*9));
					col = (int)((Math.random()*9));
				}
				for(int i = 0; i < shipSpace(x); i++)
				{
					if(orient == 1)
						cBoard[row+i][col] = 3;
					else if(orient == -1)
						cBoard[row][col+i] = 3;
				}
				break;
			case "C":
				while(!checkCell(cBoard, orient, x, row, col))
				{
					row = (int)((Math.random()*9));
					col = (int)((Math.random()*9));
				}
				for(int i = 0; i < shipSpace(x); i++)
				{
					if(orient == 1)
						cBoard[row+i][col] = 4;
					else if(orient == -1)
						cBoard[row][col+i] = 4;
				}
				break;
			case "D":
				while(!checkCell(cBoard, orient, x, row, col))
				{
					row = (int)((Math.random()*9));
					col = (int)((Math.random()*9));
				}
				for(int i = 0; i < shipSpace(x); i++)
				{
					if(orient == 1)
						cBoard[row+i][col] = 5;
					else if(orient == -1)
						cBoard[row][col+i] = 5;
				}
				break;
		}
	}
	
	public static boolean checkCell(int[][] cBoard, int orient, String x, int row, int col)
	{
		if((col+shipSpace(x)>10)&&orient==-1)
			return false;
		if((row+shipSpace(x)>10)&&orient==1)
			return false;
		for(int i = 0; i < shipSpace(x); i++)
		{
			if(orient == 1)
			{
				if(cBoard[row+i][col]!=0)
					{return false;}
			}
			else if(orient == -1)
			{
				if(cBoard[row][col+i]!=0)
					{return false;}
			}
		}
		return true;
	}
	
	public static boolean isValid(String shipCell)
	{
		if(shipCell.length() != 2 && shipCell.length() != 3)
		{
			return false;
		}
		else if(!isCapLetter(shipCell.charAt(0)))
		{
			return false;
		}
		String cellNumber = Character.toString(shipCell.charAt(1));
		if(shipCell.length() == 3)
			cellNumber += Character.toString(shipCell.charAt(2));
		if(!isNumber(cellNumber))
		{
			return false;
		}
		return true;
	}
	
	public static void placeShip(String shipCell, int[][] pBoard, String orient, String place)
	{
		int row = convertLetter(shipCell);
		int col = convertNumber(shipCell);
		switch(place)
		{
			case "A":
				if(orient.equals("V"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row+i][col] = 1;
					}
				}
				else if(orient.equals("H"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row][col+i] = 1;
					}
				}
				break;
			case "B":
				if(orient.equals("V"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row+i][col] = 2;
					}
				}
				else if(orient.equals("H"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row][col+i] = 2;
					}
				}
				break;
			case "S":
				if(orient.equals("V"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row+i][col] = 3;
					}
				}
				else if(orient.equals("H"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row][col+i] = 3;
					}
				}
				break;
			case "C":
				if(orient.equals("V"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row+i][col] = 4;
					}
				}
				else if(orient.equals("H"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row][col+i] = 4;
					}
				}
				break;
			case "D":
				if(orient.equals("V"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row+i][col] = 5;
					}
				}
				else if(orient.equals("H"))
				{
					for(int i = 0; i < shipSpace(place); i++)
					{
						pBoard[row][col+i] = 5;
					}
				}
				break;
		}
	}
	
	public static boolean isOnGrid(String shipCell, int[][] pBoard, String orient, String place)
	{
		int row = convertLetter(shipCell);
		int col = convertNumber(shipCell);
		if(orient.equals("H"))
		{
			if((col+shipSpace(place)>10))
				return false;
			for(int i = 0; i < shipSpace(place); i++)
			{
				if(pBoard[row][col+i] != 0)
					return false;
			}
		}
		else if(orient.equals("V"))
		{
			if((row+shipSpace(place)>10))
				return false;
			for(int i = 0; i < shipSpace(place); i++)
			{
				if(pBoard[row+i][col] != 0)
					return false;
			}
		}			
		return true;	
	}
	
	public static int convertLetter(String shipCell)
	{
		switch(shipCell.charAt(0))
		{
			case 'A':
				return 0;
			case 'B':
				return 1;
			case 'C':
				return 2;
			case 'D':
				return 3;
			case 'E':
				return 4;
			case 'F':
				return 5;
			case 'G':
				return 6;
			case 'H':
				return 7;
			case 'I':
				return 8;
			case 'J':
				return 9;
		}
		return 0;
	}
	
	public static int convertNumber(String shipCell)
	{
		switch(shipCell.charAt(1))
		{
			case '1':
				if(shipCell.length() == 3)
				{
					if(shipCell.charAt(2) == '0')
					{
						return 9;
					}
				}
				else
				return 0;
			case '2':
				return 1;
			case '3':
				return 2;
			case '4':
				return 3;
			case '5':
				return 4;
			case '6':
				return 5;
			case '7':
				return 6;
			case '8':
				return 7;
			case '9':
				return 8;
			
		}
		return 0;
	}
		
	public static boolean isCapLetter(char x)
	{
		return (x == 'A'||x == 'B'||x == 'C'||x == 'D'||x == 'E'||x == 'F'||x == 'G'||x == 'H'||x == 'I'||x == 'J');
	}
	
	public static boolean isNumber(String x)
	{
		return (x.equals("1") ||x.equals("2") ||x.equals("3") ||x.equals("4") ||x.equals("5") ||x.equals("6") ||x.equals("7") ||x.equals("8") ||x.equals("9") ||x.equals("10"));
	}
	
	public static void shipName(String place)
	{
		if(place.equals("A"))
			System.out.print("Aircraft Carrier");
		else if(place.equals("B"))
			System.out.print("Battleship");
		else if(place.equals("S"))
			System.out.print("Submarine");
		else if(place.equals("C"))
			System.out.print("Cruiser");
		else if(place.equals("D"))
			System.out.print("Destroyer");
	}
	
	public static int shipSpace(String place)
	{
		if(place.equals("A"))
			return 5;
		else if(place.equals("B"))
			return 4;
		else if(place.equals("S"))
			return 3;
		else if(place.equals("C"))
			return 3;
		else if(place.equals("D"))
			return 2;
		else return 0;
	}
	
	public static boolean doesntEx(String place)
	{
		if(!place.equals("A")&&!place.equals("B")&&!place.equals("S")&&!place.equals("C")&&!place.equals("D"))
			return false;
		else
			return true;
	}
	
	public static boolean alreadyPlaced(String place, boolean a, boolean b, boolean c, boolean d, boolean e)
	{
		if(place.equals("A") && !a)
		{
			return false;
		}
		if(place.equals("B") && !b)
		{
			return false;
		}
		if(place.equals("S") && !c)
		{
			return false;
		}
		if(place.equals("C") && !d)
		{
			return false;
		}
		if(place.equals("D") && !e)
		{
			return false;
		}
		else
			return true;
	}
	
	public static void showShips(boolean a, boolean b, boolean c, boolean d, boolean e)
	{
		if(a)
			System.out.println("(A)ircraft Carrier  -  5 Cells");
		if(b)
			System.out.println("(B)attleship        -  4 Cells");
		if(c)
			System.out.println("(S)ubmarine         -  3 Cells");
		if(d)
			System.out.println("(C)ruiser           -  3 Cells");
		if(e)
			System.out.println("(D)estroyer         -  2 Cells");
	}
	
	public static void printBoard(int[][] board)
	{
		int ch = 65;
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		for(int x = 0; x < board.length; x++)
		{
			System.out.print(((char)ch)+" ");
			ch++;
			for(int y = 0; y < board.length; y++)
			{
				if(board[x][y] == 0)
					System.out.print("  ");
				else if(board[x][y] == -1)
					System.out.print("X ");
				else if(board[x][y] == -2)
					System.out.print("O ");
				else if(board[x][y] == 1)
					System.out.print("A ");
				else if(board[x][y] == 2)
					System.out.print("B ");
				else if(board[x][y] == 3)
					System.out.print("S ");
				else if(board[x][y] == 4)
					System.out.print("C ");
				else if(board[x][y] == 5)
					System.out.print("D ");
			}
			battleship.line();
		}
	}
	
		public static void printBoardHidden(int[][] board)
	{
		int ch = 65;
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		for(int x = 0; x < board.length; x++)
		{
			System.out.print(((char)ch)+" ");
			ch++;
			for(int y = 0; y < board.length; y++)
			{
				if(board[x][y] == 0)
					System.out.print("  ");
				else if(board[x][y] == -1)
					System.out.print("X ");
				else if(board[x][y] == -2)
					System.out.print("O ");
			}
			battleship.line();
		}
	}
}