public class question 
{
	//Gets passed choice (Which set to use) and q (The question id within that choice)
	public static void ask(int c, int q)
	{	
		//Prints question and choices
		switch(c)
		{
		case 1:
			switch(q)
			{
			case 1:
				System.out.println("The answer to this question is 1.");
				System.out.println("(1) 1");
				System.out.println("(2) 2");
				System.out.println("(3) 3");
				System.out.println("(4) 4");
				break;
			case 2:
				System.out.println("The answer to this question is 2.");
				System.out.println("(1) 1");
				System.out.println("(2) 2");
				System.out.println("(3) 3");
				System.out.println("(4) 4");
				break;
			case 3:
				System.out.println("The answer to this question is 3.");
				System.out.println("(1) 1");
				System.out.println("(2) 2");
				System.out.println("(3) 3");
				System.out.println("(4) 4");
				break;
			case 4:
				System.out.println("The answer to this question is 4.");
				System.out.println("(1) 1");
				System.out.println("(2) 2");
				System.out.println("(3) 3");
				System.out.println("(4) 4");
				break;
			case 5:
				System.out.println("The answer to this question is 1.");
				System.out.println("(1) 1");
				System.out.println("(2) 2");
				System.out.println("(3) 3");
				System.out.println("(4) 4");
				break;
			}
			//chem foundation
			break;
		case 2:
			switch(q)
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
			//chem enthalpy
			break;
		case 3:
			switch(q)
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
			//chem energy
			break;
		case 4:
			switch(q)
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
			//calc limits
			break;
		case 5:
			switch(q)
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
			//calc deriv
			break;
			default:
		}
	}
	
	//Given the subject choice and the question id, it returns the correct answer for that question
	public static int set(int c, int q)
	{
		switch(c)
		{
		case 1:
			switch(q)
			{
			case 1:
				//The answer for this question is 1, etc.
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 1;
				default:
					return 0;
			}
			//chem foundation
		case 2:
			switch(q)
			{
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 1;
				default:
					return 0;
			}
		case 3:
			switch(q)
			{
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 1;
				default:
					return 0;
			}
			//chem energy
		case 4:
			switch(q)
			{
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 1;
				default:
					return 0;
			}
			//calc limits
		case 5:
			switch(q)
			{
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 1;
				default:
					return 0;
			}
			//calc deriv
			default:
		}
		return 0;
	}
}
