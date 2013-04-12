import java.lang.Math;
public class enemies 
{
	int ehp = 0;
	int eatk;
	public enemies(int eid)
	{
		if(eid == 1)
		{
			ehp = 120;
		}
		if(eid == 2)
		{
			ehp = 200;
		}
		if(eid == 3)
		{
			ehp = 350;
		}
		if(eid == 4)
		{
			ehp = 600;
		}
		if(eid == 5)
		{
			ehp = 1000;
		}
	}
	public static int eatk(int eid)
	{
		int eatk = 0;
		double x;
		if(eid == 1)
		{
			x = Math.random();
			if(x < .8)
			{
				System.out.println("The slime extends and slams into you.");
				eatk = 80;
			}
			else if(x >= .8)
			{
				System.out.println("The slime envelops your body, choking you.");
				eatk = 150;
			}
		}
		return eatk;
	}
}
