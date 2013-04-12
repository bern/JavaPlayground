import java.util.Scanner;
import java.lang.Math;
public class mainbattler 
{
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.println("Choose a class");
		System.out.println("1 - Warrior");
		System.out.println("2 - Ninja");
		System.out.println("3 - Magician");
		int choice = input.nextInt();
		if(choice==3)
		{
			System.out.println("You have chosen the Magician!");
		}
		else if(choice==1)
			System.out.println("You have chosen the Warrior!");
		else if(choice==2)
			System.out.println("You have chosen the Ninja!");
		System.out.println("");
		battle(choice);
	}
	public static void battle(int choice)
	{
		int phit, ehit, eid, type, eatk, mp;
		mp = 0;
		boolean canatk = true;
		double damage = 0;
		int dodge = 0;
		int dmg = 0;
		int frostt = 0;
		int undine = 0;
		boolean block = false;
		boolean tied = false;
		double rand = 0;
		int spektor = 0;
		int wregen = 0;
		eid = 1;
		enemies e1 = new enemies(eid);
		enemies e2 = new enemies(2);
		enemies e3 = new enemies(3);
		enemies e4 = new enemies(4);
		enemies e5 = new enemies(5);
		ehit = e1.ehp;
		prof you = new prof(choice);
		phit = you.hp;
		if(choice == 3)
		{
			mp = you.mp;
		}
		while(ehit > 0 && phit > 0)
		{
			if(choice==1)
			{
				wregen++;
				if(wregen >4)
				{
					System.out.println("Your warrior spirit allows you to keep going.");
					System.out.println("You regenerate 200 HP.");
					phit+=200;
					wregen = 0;
				}
			}
			if(choice==3)
			{
				mp+=5;
				System.out.println("You feel ancient energies flowing into you.");
				System.out.println("You regenerate 5 MP.");
			}
			System.out.println("Enemy HP = "+ehit);
			System.out.println("");
			System.out.println("Player HP = "+phit);
			if(choice == 3)
			{
				System.out.println("Player MP = "+mp);
			}
			if(canatk == true)
			{
			System.out.println(you.menu);
			System.out.print("Make an action selection: ");
			int act = input.nextInt();
			type = prof.move(act, choice);
			if(type > 0 && type < 5)
			{
			System.out.println("You have inflicted "+prof.attack(choice, type)+" points of damage.");
			ehit -= prof.attack(choice, type);
			}
			if(prof.attack(choice, type)==45)
				canatk = false;
			if(type == 5)
			{
			block = true;
			}
			if(type == 6)
			{
				dodge = 5;
			}
			if(type == 7)
			{
				System.out.println("You have inflicted 40 points of damage.");
				ehit -= 40;
			}
			if(type == 8)
			{
				if(!tied)
				tied = true;
			}
			if(type == 9)
			{
				phit += 100;
			}
			if(type == 11)
			{
				int fireb = 40;
				if(prof.focus)
					fireb/=2;
				if(mp >= fireb)
				{
				mp-=fireb;
				ehit-=20;
				System.out.println("You have inflicted 20 points of damage.");
				if(prof.focus)
					prof.focus = false;
				}
				else
				{
					System.out.println("You have insufficient MP to cast this.");
				}
			}
			if(type == 12)
			{
				int frost = 50;
				if(prof.focus)
					frost/=2;
				if(mp>=frost)
				{
				mp -= frost;
				frostt = 2;
				if(prof.focus)
					prof.focus = false;
				}
				else
				{
					System.out.println("You have insufficient MP to cast this.");
				}
			}
			if(type == 13)
			{
				int thund = 70;
				if(prof.focus)
					thund/=2;
				if(mp>=thund)
				{
				mp-=thund;
				ehit-=40;
				System.out.println("You have inflicted 40 points of damage.");
				if(prof.focus)
					prof.focus = false;
				}
				else
				{
					System.out.println("You have insufficient MP to cast this.");
				}
			}
			if(type == 14)
			{
				//cost 30
				//damage 35
				if(mp>=30)
				{
					mp-=30;
					System.out.println("You have inflicted 35 points of damage.");
					ehit-=35;
					prof.focus = false;
				}
				else
				{
					System.out.println("You have insufficient MP to cast this.");
				}
				
			}
			if(type == 15)
			{
				if(mp>=30)
				{
					mp-=30;
					undine = 4;
					prof.focus = false;
				}
				else
				{
					System.out.println("You have insufficient MP to cast this.");
				}
				//10dpt for 4 turns
			}
			if(type == 16)
			{
				if(mp>=30)
				{
					mp-=30;
					spektor = 2;
					prof.focus = false;
				}
				else
				{
					System.out.println("You have insufficient MP to cast this.");
				}
				//50% dodge for 2 turns
			}
			if(type == 17)
			{
				//cost 45
				//heal 100, damage 50
				if(mp>=45)
				{
					mp-=45;
					ehit-=50;
					phit+=100;
					System.out.println("You heal 100 points and inflict 50 points of damage.");
					prof.focus = false;
				}
				else
				{
					System.out.println("You have insufficient MP to cast this.");
				}	
			}
			if(undine > 0)
			{
				System.out.println("A shark circling the enemy leaps out of the water and inflicts 10 damage.");
				ehit -= 10;
				undine--;
			}
			}
			else
			{
				System.out.println("You require a turn to rest.");
				canatk = true;
			}
			if(ehit > 0)
			{
				System.out.println("");
				if(tied)
				{
					rand = Math.random();
					if(rand > .4)
					{
						System.out.println("The enemy broke free of its binding!");
						tied = false;
					}
				}
				else if(!tied)
				{
				eatk = enemies.eatk(eid);
				if(block)
				{
					damage = prof.reduction(1) * eatk;
					dmg = (int)damage;
					block = false;
					dmg -= 20;
					System.out.println("The enemy inflicts "+dmg+" points of damage.");
				}
				else if(dodge > 0)
				{
					if(prof.dodge(choice))
					{
						dmg = 0;
						System.out.println("You jump out of the way and dodge the attack.");
					}
					else
					{
						dmg = eatk;
						System.out.println("The enemy inflicts "+dmg+" points of damage.");
					}
					dodge--;
				}
				else if(spektor > 0)
				{
					if(prof.dodge(choice))
					{
						dmg = 0;
						System.out.println("Spektor's curse prevents the enemy from seeing its target.");
					}
					else
					{
						dmg = eatk;
						System.out.println("The enemy inflicts "+dmg+" points of damage.");
					}
					spektor--;
				}
				else if(frostt > 0)
				{
					dmg = eatk/2;
					System.out.println("The enemy inflicts a reduced "+dmg+" points of damage.");
					frostt--;
				}
				else
				{
					dmg = eatk;
					System.out.println("The enemy inflicts "+dmg+" points of damage.");
				}
				System.out.println(" ");
				phit -= dmg;
				if(phit <= 0)
					System.out.println("You have been defeated.");
				}
			}
			else
			{
				System.out.println("");
				System.out.print("You have defeated the slime!");
			}
		}
	}
}
