import java.lang.Math;
public class card 
{
	//Chooses a random card id from 1 to 13
	public static int rand()
	{
		int id = (int)(Math.random()*13);
		id++;
		return id;
	}
	
	//Assigns the name of the card given its id
	public static String name(int id)
	{
		switch(id)
		{
		case 1:
			return "2";
		case 2:
			return "3";
		case 3:
			return "4";
		case 4:
			return "5";
		case 5:
			return "6";
		case 6:
			return "7";
		case 7:
			return "8";
		case 8:
			return "9";
		case 9:
			return "10";
		case 10:
			return "Jack";
		case 11:
			return "Queen";
		case 12:
			return "King";
		case 13:
			return "Ace";
			default:
				return "ERROR";
		}
	}
	
	//Assigns the value of the card given its id
	public static int val(int id)
	{
		switch(id)
		{
		case 1:
			return 2;
		case 2:
			return 3;
		case 3:
			return 4;
		case 4:
			return 5;
		case 5:
			return 6;
		case 6:
			return 7;
		case 7:
			return 8;
		case 8:
			return 9;
		case 9:
			return 10;
		case 10:
			return 10;
		case 11:
			return 10;
		case 12:
			return 10;
			default:
				return 0;
		}
	}
}

