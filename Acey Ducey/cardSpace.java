public class cardSpace
{
	private int value;

	public cardSpace(int val)
	{
		while(val > 13)
			val-=13;
		value = val;
	}
	
	public int getVal()
	{
		return value;
	}

	public void setVal(int val)
	{
		value = val;
	}

	public static String cardName(int val)
	{
		switch(val)
		{
			case 1:
				return "ace";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
			case 10:
				return "ten";
			case 11:
				return "jack";
			case 12:
				return "queen";
			case 13:
				return "king";
		}
		return "wat.";
	}

	public String toString()
	{
		return cardName(value);
	}
}

	
