//Uses a stack to see whether a word or set of words (sans spaces) is a palindrome

import java.util.Scanner;

public class palindrome {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("**PALINDROME CHECKER**");
		System.out.println("A palindrome is a word or set of words which spell the same thing\nforwards and backwards - think \'racecar\'! Simply enter a word\nor set of words and I'll check if it's a palindrome.\n");
		System.out.print("Word/Phrase to be checked (Case-insensitive, no punctuation): ");
		String forwards = in.nextLine();
		
		forwards = forwards.toLowerCase();
		
		char curr = ' ';
		String nospaceforwards = "";
		String nospacebackwards = "";
		
		Stack<String> reverser = new Stack<String>();
		
		for(int i = 0; i < forwards.length(); i++) {
			curr = forwards.charAt(i);
			if(curr != ' ') {
				nospaceforwards += curr;
				reverser.push((String)(curr+""));
			}
		}
		
		while(reverser.size() != 0) {
			nospacebackwards += reverser.pop();
		}
		
		if(nospaceforwards.equals(nospacebackwards)) {
			System.out.println("\nYou have entered a palindrome!");
		} else System.out.println("\nYou have not entered a palindrome.");
	}
}