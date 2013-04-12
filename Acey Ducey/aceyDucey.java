import java.util.Scanner;
import java.lang.Math;

public class aceyDucey
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to ACEY-DUCEY - the game of chance and luck!");
		line();
		System.out.println("You will be dealt two cards, and you have to bet as to");
		System.out.println("the third call will fall in-between the two dealt cards!");
		System.out.println("Bet carefully or bet big, it's all luck in the end!");
		System.out.println("Your goal is to get from 10 to 25 chips, and you can");
		System.out.println("bet as many as you have each round, but the minimum bet is one!");
		System.out.println("And REMEMBER: if you get dealt an Ace as the first card,");
		System.out.println("you get to choose [high] or [low]. That means it can either");
		System.out.println("hold the highest value of them all, or the lowest! But if");
		System.out.println("an Ace is dealt as your second card, it's [high] by default.");
		line();
		System.out.println("Are you ready to play? Type 'GO' to get started!");
		System.out.print("LET'S ");
		String filler = input.next();
		advance();
		play();

	}

	public static void play()
	{
		Scanner input = new Scanner(System.in);
		int playerWealth = 10;
		int whichCard = 0;
		int val1, val2, val3;
		int bet = 0;
		int hands = 0;

		cardSpace[] deck = new cardSpace[52];
		for(int i = 0; i < deck.length; i++)
		{
			deck[i] = new cardSpace(i+1);
		}
	
		shuffle(deck);

		while(playerWealth > 0 && playerWealth < 25)
		{	
			hands++;

			if(whichCard+3 > 51)
			{
				System.out.println("Shuffling the deck...");
				line();
				shuffle(deck);
				whichCard = 0;
			}
			line();
			System.out.print("Your first card is a");
			if(deck[whichCard].getVal() == 8 || deck[whichCard].getVal() == 1)
				System.out.print("n");
			System.out.println(" "+deck[whichCard]+".");
			val1 = aceChecker(deck[whichCard].getVal());
			whichCard++;

			System.out.print("Your second card is a");
			if(deck[whichCard].getVal() == 8 || deck[whichCard].getVal() == 1)
				System.out.print("n");
			System.out.println(" "+deck[whichCard]+".");
			if(deck[whichCard].getVal() == 1)
				val2 = 14;
			else
				val2 = deck[whichCard].getVal();
			whichCard++;
			
			line();
			System.out.println("You have "+playerWealth+" chips to spend.");
			System.out.print("How many would you like to bet? ");
			if(playerWealth == 1)
				System.out.print("(1) ");
			else
				System.out.print("(1 - "+playerWealth+") ");
			
			bet = input.nextInt();
			if(bet > playerWealth || bet < 1)
			{
				System.out.println("Incorrect bet, betting 1 by default.");
				bet = 1;
			}
			else
				System.out.println("Alright, your bet of "+bet+" is set!");
			
			line();
			System.out.print("Your third card is a");
			if(deck[whichCard].getVal() == 8 || deck[whichCard].getVal() == 1)
				System.out.print("n");
			System.out.print(" "+deck[whichCard]+".");
			if(deck[whichCard].getVal() == 1)
				val3 = 14;
			else
				val3 = deck[whichCard].getVal();
			whichCard++;
			line();
			if(val1 > val2)
			{
				if(val3 < val1 && val3 > val2)
				{
					System.out.println("Nice job, you got it!");
					System.out.println("You receive "+bet+" chips!");
					playerWealth+=bet;
				}
				else
				{
					System.out.println("Oh, sorry...");
					System.out.println("You lost "+bet+" chips.");
					playerWealth-=bet;
				}
			}
			else if(val2 > val1)
			{
				if(val3 < val2 && val3 > val1)
				{
					System.out.println("Nice job, you got it!");
					System.out.println("You receive "+bet+" chips!");
					playerWealth+=bet;
				}
				else
				{
					System.out.println("Oh, sorry...");
					System.out.println("You lost "+bet+" chips.");
					playerWealth-=bet;
				}
			}
			else if(val1 == val2)
			{
					System.out.println("Oh, sorry...");
					System.out.println("You lost "+bet+" chips.");
					playerWealth-=bet;
			}
		}
		
		advance();
		if(playerWealth < 1)
		{
			System.out.println("Sorry, you lost :(");
			System.out.println("Better luck next time!");
		}
		else
		{
			System.out.println("Wow, you won and it only took you "+hands+" hands to do it!");
			System.out.println("See if you can beat it next time!");
		}
	}

	public static void advance()
	{
		for(int i = 0; i < 100; i++)
			System.out.println();
	}
	
	public static void line()
	{
		System.out.println();
	}

	public static void shuffle(cardSpace[] deck)
	{
		int tempvalue, temp;

		for(int i = 0; i < deck.length; i++)
		{
			tempvalue = (int)(Math.random()*52);
			temp = deck[i].getVal();
			deck[i].setVal(deck[tempvalue].getVal());
			deck[tempvalue].setVal(temp);
		}
	}

	public static int aceChecker(int val)
	{
		Scanner input = new Scanner(System.in);
		String v = "";
		if(val == 1)
		{
			System.out.println("Would you like your ace to be (H)igh or (L)ow?");
			System.out.print("(Enter the letter inside the parentheses in uppercase) ");
			v = input.next();

			if(v.equalsIgnoreCase("L"))
			{
				System.out.println("Your ace is set to a low value.");
				return 1;
			}
			else if(v.equalsIgnoreCase("H"))
			{
				System.out.println("Your ace is set to a high value.");
				return 14;
			}
			else
			{
				System.out.println("Incorrect input. Your ace is set to high by default.");
				return 14;
			}
		}
		else
			return val;
	}
}
