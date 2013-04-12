import java.util.*;
import java.lang.*;

public class sieveTest {
	public static void main(String[] args)
	{
		int currIn = 0;
		int zerolength = 0;
		int checkerValue = 2;
		int counter = 0;
		boolean done = false;
		Scanner in = new Scanner(System.in);
	
		System.out.print("Input n: ");
		int n = in.nextInt();
		
		System.out.println();
		
		int[] list = new int[n-1];
		
		//initializes the array to include all numbers from 2-n
		for(int i = 0; i < list.length; i++)
		{
			list[i] = (i+2);
		}
		
		long eps = System.currentTimeMillis();
		while(!done)//counter < list.length-1)
		{
			while(checkerValue == 0)
			{
				counter++;
				if(counter >= list.length)
				{
					done = true;
					break;
				}
				//System.out.println("1counter at "+counter);
				checkerValue = list[counter];
			}
			
			if(!done)
			{
				//System.out.println("Looking for multiples of "+checkerValue);
				for(int i = checkerValue; i < list.length; i++)
				{
					if(list[i] % checkerValue == 0)
					{
						list[i] = 0;
					}
				}
				
				zerolength = 0;
				currIn = 0;
				
				for(int i = 0; i < list.length; i++)
				{
					if(list[i] != 0)
					{
						zerolength++;
					}
				}
				
				int[] listb = new int[zerolength];
				
				for(int i = 0; i < list.length; i++)
				{
					if(list[i] != 0)
					{
						listb[currIn] = list[i];
						currIn++;
					}
				}
				
				list = listb;
				
				/*for(int i = 0; i < list.length; i++)
				{
					System.out.print(list[i]+" ");
				}
				System.out.println();
				System.out.println();*/
			}
			
			counter++;
			if(counter >= list.length)
			{
				done = true;
			}
			else {
				//System.out.println("2counter at "+counter);
				checkerValue = list[counter];
			}
		}
		eps = System.currentTimeMillis() - eps;
		double secs = eps / 1000;
		for(int i = 0; i < list.length; i++)
		{
			System.out.print(list[i]+" ");
		}
		System.out.println("Operation time: "+secs+" seconds");
	}
}