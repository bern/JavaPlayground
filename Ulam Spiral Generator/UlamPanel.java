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

public class UlamPanel extends JPanel{

	BufferedImage dot;

	public static int x = 0; public static int y = 0;
	public static int xMod = 0;
	public static int yMod = 0;
	public static boolean[] isPrime;
	public static int totalCount = 0;
	public static int dirCount = 0;
	public static int currDir = 0;
	public static int incrementDirCount = 0;
	public static int dir = 0;
	public static int dotIndex = 0;
	
	final static String[] dotLocations = {"thedot1.png", "thedot2.png", "thedot3.png", "thedot4.png"};

	//Simple constructor
	//Creates bufferedimage of the dot
	public UlamPanel() {
		try {
			dot = ImageIO.read(new File(dotLocations[dotIndex]));
		} catch (Exception e) {}
		repaint();
	}
	
	public static void catchArr(boolean[] arr) {
		isPrime = arr;
		
		if(arr.length <= 62500) {dotIndex = 3; xMod = 4; x = 496; y = 496;}
		else if(arr.length <= 110889) {dotIndex = 2; xMod = 3; x = 497; y = 497;}
		else if(arr.length <= 250000) {dotIndex = 1; xMod = 2; x = 498; y = 498;}
		else {dotIndex = 0; xMod = 1; x = 499; y = 499;}
	}
	
	//Draws the spiral itself
	//This is really hard to read, so sorry about that, but it works
	//I promise.
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		while(totalCount < isPrime.length) {
			
			x += xMod;
			y += yMod;
			
			if(isPrime[totalCount])
				g.drawImage(dot, x, y, this);
			
			if(currDir == dirCount) {
				incrementDirCount++;
				currDir = 0;
				if(dir == 3) dir = 0;
				else dir++;
			}
			else currDir++;
			
			if(incrementDirCount == 2) {
				incrementDirCount = 0;
				dirCount++;
			}
				
			if(dir == 0) {
				switch(dotIndex) {
					case 0:
						xMod = 1; yMod = 0;
						break;
					case 1:
						xMod = 2; yMod = 0;
						break;
					case 2:
						xMod = 3; yMod = 0;
						break;
					case 3:
						xMod = 4; yMod = 0;
						break;
					default:
						break;
				}
			}
			if(dir == 1) {
				switch(dotIndex) {
					case 0:
						xMod = 0; yMod = -1;
						break;
					case 1:
						xMod = 0; yMod = -2;
						break;
					case 2:
						xMod = 0; yMod = -3;
						break;
					case 3:
						xMod = 0; yMod = -4;
						break;
					default:
						break;
				}
			}
			if(dir == 2) {
				switch(dotIndex) {
					case 0:
						xMod = -1; yMod = 0;
						break;
					case 1:
						xMod = -2; yMod = 0;
						break;
					case 2:
						xMod = -3; yMod = 0;
						break;
					case 3:
						xMod = -4; yMod = 0;
						break;
					default:
						break;
				}
			}
			if(dir == 3) {
				switch(dotIndex) {
					case 0:
						xMod = 0; yMod = 1;
						break;
					case 1:
						xMod = 0; yMod = 2;
						break;
					case 2:
						xMod = 0; yMod = 3;
						break;
					case 3:
						xMod = 0; yMod = 4;
						break;
					default:
						break;
				}
			}
			
			totalCount++;
		}
	}
}