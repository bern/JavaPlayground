import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.Math;
import java.awt.Graphics2D;
import java.util.Scanner;

public class UlamGen extends JFrame {

	public static UlamPanel mainWindow;

	public UlamGen(String s) {
		super(s);
		mainWindow = new UlamPanel();
		add(mainWindow);
	}	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("**ULAM SPIRAL GENERATOR**");
		System.out.println("\nThis program generates the Ulam Spiral for all prime numbers");
		System.out.println("less than or equal to a given integer, n (Max 1000000)");
		System.out.print("\nn: ");
		int n = in.nextInt();
		
		boolean[] isPrime = new boolean[n];
		
		for(int i = 0; i < isPrime.length; i++) isPrime[i] = true;
		
		fillArr(isPrime);
		
		UlamPanel.catchArr(isPrime);
		
		printArr(isPrime);
		
		UlamGen spiral = new UlamGen("Ulam Spiral up to "+n);
		spiral.setSize(1000,1000);
		spiral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spiral.setVisible(true);
	}
	
	//A neat little method that uses the Sieve of Eratosthenes
	//An easy and efficient way to find all primes between 2 and n
	public static void fillArr(boolean[] arr) {
	
		int n = 1;
		int checker = 0;
		arr[0] = false;
		
		while(n < arr.length) {
			checker = (n+1);
			if(arr[checker-1]) {
				checker += (n+1);
				while(checker <= arr.length) {
					arr[checker-1] = false;
					checker += (n+1);
				}
			}
			n++;
		}
	}
	
	public static void printArr(boolean[] arr) {
		System.out.println("\nPrime numbers in array are: ");
		int countPrime = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]) { System.out.print((i+1)+" "); countPrime++; }
		}
		System.out.println("\n\nFor a total of "+countPrime+" primes");
	}
}