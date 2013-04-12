import java.lang.Math;

public class Shuffler
{
	public static void main(String[] args)
	{
		int tempvalue = 0;
		int oldtemp = 0;
		int randcard = 0;
		
		int[] deck = new int[52];
		for(int x = 0; x < deck.length; x++)
			deck[x] = x;
			
		System.out.println("Original deck:");
		for(int x = 0; x < deck.length; x++)
			System.out.println(deck[x]);
		
		for(int x = 0; x < 52; x++)
		{
			randcard = (int)(Math.random()*52);
			oldtemp = deck[x];
			deck[x] = deck[randcard];
			deck[randcard] = oldtemp;
		}
		
		System.out.println();
		System.out.println("Shuffled deck:");
		for(int x = 0; x < deck.length; x++)
			System.out.println(deck[x]);
			
		for(int x = 0; x < deck.length; x++)
		{	
			for(int y = 0; y < deck.length; y++)
			{
				if(deck[y] == deck[x])
				{
					System.out.print("! ");
				}
			}
			System.out.println();
		}
	}
}