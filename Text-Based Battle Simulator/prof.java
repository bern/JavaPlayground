import java.util.Scanner;
public class prof
{
	static Scanner input = new Scanner(System.in);
	int hp = 0;
	int mp = 0;
	static int atk = 0;
	static int form = 0;
	static double dodge = 0;
	static int item = 0;
	static int spell = 0;
	static int summon = 0;
	static int numkunais = 2;
	static int numwhips = 3;
	static int numpills = 2;
	static int fballmp = 40;
	static int fbitemp = 50;
	static int thundmp = 70;
	static int frit = 30;
	static int und = 30;
	static int spek = 30;
	static int orig = 45;
	static boolean focus = false;
	String menu = "";
	public prof(int choice)
	{
		if(choice == 1)
		{
			hp = 400;
			menu = "1 - Attack\n2 - Defend\n3 - Forms";
			form = 1;
		}
		if(choice == 2)
		{
			hp = 300;
			menu = "1 - Attack\n2 - Agility\n3 - Items";
		}
		if(choice == 3)
		{
			hp = 500;
			mp = 95;
			menu = "1 - Focus\n2 - Arcana\n3 - Summon";
		}
	}
	public static int move(int act, int choice)
	{
		int type = 0;
		if(choice == 1)
		{
			switch(act)
			{
			case 1:
				if(form == 1)
				{
				System.out.println("You've chosen to attack.");
				System.out.println("You run forward and slash your sword into the enemy.");
				type = 1;
				}
				if(form == 2)
				{
					System.out.println("You've chosen to attack.");
					System.out.println("You juke from side-to-side, disorienting your enemy.");
					System.out.println("As you reach them, you slash with your right arm and stab with your left, deepening the wound.");
					type = 2;
				}
				if(form == 3)
				{
					System.out.println("You've chosen to attack.");
					System.out.println("You advance forward, well guarded.");
					System.out.println("You reach over your shield and drive your blade into the enemy.");
					type = 3;
				}
				if(form == 4)
				{
					System.out.println("You've chosen to attack.");
					System.out.println("You let out an earthshattering yell and charge your opponent.");
					System.out.println("You impale them on your blade and keep running, skewering them further.");
					System.out.println("You rip the blade out, panting. You require one turn to rest.");
					type = 4;
				}
				break;
			case 2:
				if(form == 1 || form == 3)
				{
				System.out.println("You've chosen to defend.");
				System.out.println("You raise your shield to guard yourself from the next attack.");
				type = 5;
				}
				else
				{
					System.out.println("Your form choice prevents you from blocking.");
				}
				break;
			case 3:
				System.out.println("You've chosen to switch forms.");
				System.out.println("1 - Basic Stance");
				System.out.println("2 - Cobra Stance");
				System.out.println("3 - Bulwark Stance");
				System.out.println("4 - Berserker Stance");
				System.out.print("Which form would you like to switch to? ");
				form = input.nextInt();
				switch(form)
				{
				case 1:
					System.out.println("You extend your left arm, holding the shield and poise your right arm to strike with the sword.");
					form = 1;
					break;
				case 2:
					System.out.println("You holster your shield and break your sword into two smaller, more slender blades.");
					form = 2;
					break;
				case 3:
					System.out.println("You position your shield directly in front of you and your blade behind that. You crouch lower.");
					form = 3;
					break;
				case 4:
					System.out.println("You holster your shield and grip your sword with two hands.");
					form = 4;
					break;
					default:
						System.out.println("Invalid choice.");
				}
				break;
				default:
				System.out.println("Invalid choice.");
			}
		}
		if(choice == 2)
		{
			switch(act)
			{
			case 1:
				System.out.println("You've chosen to attack.");
				System.out.println("You leap onto the enemy and sink your kunai knife into them.");
				//attack
				type = 1;
				break;
			case 2:
				System.out.println("You crouch down and push off from the ground.");
				System.out.println("The increase in speed gives you a chance to dodge attacks.");
				//agility
				type = 6;
				break;
			case 3:
				//items
				System.out.println("You open up a pouch hanging around your back.");
				System.out.println("1 - Exploding Kunai ("+numkunais+" left)");
				System.out.println("2 - Chain Whip ("+numwhips+" left)");
				System.out.println("3 - Revitalizing Pill ("+numpills+" left)");
				System.out.print("Which item would you like to use? ");
				item = input.nextInt();
				switch(item)
				{
				case 1:
					if(numkunais > 0)
					{
						System.out.println("You reach inside the pouch and grab a kunai.");
						System.out.println("You pull a tab and the knife starts to sizzle.");
						System.out.println("You run to the side and throw it at your enemy.");
						System.out.println("It sticks into the enemy and ignites, creating a loud explosion.");
						type = 7;
						numkunais--;
					}
					else
					{
						System.out.println("You are out of exploding kunais.");
					}
					break;
				case 2:
					if(numwhips > 0)
					{
						System.out.println("You reach inside the pouch and pull out a long metal chain with two balls attached to either end.");
						System.out.println("You bring it above your head and start twirling it - fast.");
						System.out.println("The air ripples around you as you release it.");
						System.out.println("It wraps around your enemy, immobilizing them.");
						type = 8;
						numwhips--;
					}
					else
					{
						System.out.println("You are out of chain whips.");
					}
					break;
				case 3:
					if(numpills > 0)
					{
						System.out.println("You reach inside the pouch and pull out a bright blue pill.");
						System.out.println("You pop it inside your mouth and swallow.");
						System.out.println("Suddenly, you feel a lot lighter and healthier.");
						System.out.println("100 HP restored");
						type = 9;
						numpills--;
					}
					else
					{
						System.out.println("You are out of revitalizing pills.");
					}
					break;
					default:
						System.out.println("Invalid choice.");
				}
				break;
				default:
					System.out.println("Invalid choice.");
			}
		}
		if(choice == 3)
		{
			switch(act)
			{
			case 1:
				//focus
				System.out.println("You stab your staff into the ground and place your hands around the top.");
				System.out.println("You feel ancient energies begin to race across your skin and through your veins.");
				System.out.println("You close your eyes and breathe slowly.");
				System.out.println("You open them again, your pupils have turned white, and you are focused.");
				focus = true;
				type = 10;
				break;
			case 2:
				//arcana
				System.out.println("You know the following spells:");
				fballmp = 40;
				fbitemp = 50;
				thundmp = 70;
				if(focus)
				{
					fballmp/=2;
					fbitemp/=2;
					thundmp/=2;
				}
				System.out.println("1 - Fireball ("+fballmp+" MP)");
				System.out.println("2 - Frostbite ("+fbitemp+" MP)");
				System.out.println("3 - Thunder ("+thundmp+" MP)");
				System.out.print("Which spell would you like to cast? ");
				spell = input.nextInt();
				switch(spell)
				{
				case 1:
					System.out.println("You begin twirling your staff rapidly to your right. The top begins to glow bright orange.");
					System.out.println("The air around you begins to heat up, and an arcana seal forms in front of you.");
					System.out.println("You take a step back, place your staff through the seal, and an enormous sphere of fire erupts from the seal.");
					System.out.println("It hurtles towards your enemy and barrels into them, burning them badly.");
					type = 11;
					//Fireball
					break;
				case 2:
					System.out.println("You kneel on the ground and place your staff in front of you.");
					System.out.println("You feel the temperature drop rapidly as the top of your staff glows a bright blue.");
					System.out.println("Suddenly you pick up the staff and spin around, drawing a blue circle around you with the top of the staff.");
					System.out.println("You point your staff at the enemy and the blue ice shoots at them.");
					System.out.println("The enemy is encumbered by the ice and cannot attack properly.");
					type = 12;
					//Frostbite
					break;
				case 3:
					System.out.println("You slam the butt of your staff into the ground as a great clap of thunder booms from overhead.");
					System.out.println("Storm clouds quickly form and swirl above your enemy.");
					System.out.println("You slowly and decisively point your staff at your enemy and then drop the top to the ground.");
					System.out.println("As you do, a monstrous bolt of lightning comes from the storm clouds and crashes into the enemy.");
					type = 13;
					//Thunder
					break;
					default:
				}
				break;
			case 3:
				if(focus)
				{
				System.out.println("You have contracts with the following:");
				System.out.println("1 - Ifrit (30 MP)");
				System.out.println("2 - Undine (30 MP)");
				System.out.println("3 - Spektor (30 MP)");
				System.out.println("4 - Origin (45 MP)");
				System.out.print("Which spirit will you call upon? ");
				summon = input.nextInt();
				//summon
				switch(summon)
				{
				case 1:
					//ifrit
					System.out.println("The ground in front of you shudders and suddenly bursts open as a pillar of fire erupts from it.");
					System.out.println("Suddenly, the flames disappear in a gust of hot air and in their places floats Ifrit - Spirit of Fire.");
					System.out.println("He points at the enemy and the ground beneath them glows bright red.");
					System.out.println("Ifrit disappears as a similar pillar of fire engulfs the enemy in intense heat.");
					type = 14;
					break;
				case 2:
					System.out.println("The ground around you begins to shimmer and slowly turns into a choppy sea of water.");
					System.out.println("You and your enemy seem to be able to stand on it fine.");
					System.out.println("Suddenly, a shark emerges from the abyss and on its back stands Undine - Spirit of Water.");
					System.out.println("She motions towards the enemy and sinks back into the abyss as you see four fins begin to circle the enemy hungrily.");
					type = 15;
					//undine
					break;
				case 3:
					System.out.println("The air grows still and all is quiet.");
					System.out.println("All of a sudden, the entire world goes black. All you can see is yourself.");
					System.out.println("A ghastly figure appears in front of you: Spektor - Spirit of Darkness.");
					System.out.println("He lifts a finger to his mouth and disappears in an instant.");
					System.out.println("The darkness around you fades and enters your enemy's body. You see their eyes cloud with jet black.");
					type = 16;
					//spektor
					break;
				case 4:
					System.out.println("You hear what sounds like angels singing as a ray of light slowly reaches the ground in front of you.");
					System.out.println("A celestial figure descends down the ray and stops slightly above the ground: Origin - All-Sprit.");
					System.out.println("He splits his ray of light so that one ray comes out of each of his hands. He points his right at you.");
					System.out.println("The light feels warm and inviting. You feel invigorated and healthier.");
					System.out.println("The light encompassing the enemy turns brighter and more intense as you hear a faint sizzling sound.");
					System.out.println("The enemy glows brighter and you look up just in time to see a bright white beam crash down from the sky.");
					System.out.println("\"Judgement.\" Says Origin. In a blinding flash he disappears.");
					type = 17;
					//origin
					break;
					default:
						System.out.println("Invalid choice.");
				}
				}
				else
				{
					System.out.println("You do not have the necessary focus to summon an otherworldly being.");
				}
				break;
				default:
					System.out.println("Invalid choice.");
			}
		}
		return type;
	}
	public static int attack(int choice, int form)
	{
		int atk = 0;;
		if(choice == 1)
		{
			atk = 20;
			switch(form)
			{
			case 2:
				atk += 10;
				break;
			case 3:
				atk -= 10;
				break;
			case 4:
				atk += 25;
			}
		}
		if(choice == 2)
		{
			atk = 15;
		}
		return atk;
	}
	public static double reduction(int choice)
	{
		double reduc = 0;
		if(choice == 1)
		{
			if(form==1)
			reduc = .3;
			else if(form==3)
				reduc = .7;
		}
		return reduc;
	}
	public static boolean dodge(int choice)
	{
		dodge = Math.random();
		if(choice==2)
		return(dodge < .4);
		else if(choice==3)
		return(dodge < .7);
		else
			return false;
	}
	public void lines()
	{
		int lines = 100;
		for(int x = 0; x < lines; x++)
		{
			System.out.println("");
		}
	}
}
