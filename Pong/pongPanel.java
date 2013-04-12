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
 
public class pongPanel extends JPanel {

    //fields on fields on fields
    BufferedImage p1, p2, bord, objective, p1win, p2win;
    public static int p1score = 0;
    public static int p2score = 0;
    private final static int P1X = 20;
    public static int P1Y = 30;
    public static int p1Move = 0;
    public static int p2Move = 0;
    public static int P2Y = 30;
    private final static int P2X = 590;
    private final static int BORDERY = 0;
    private final static int BORDERX = 300;
    public static int ballX = (int)(Math.random()*300);
    public static final int ballY = 70;
    public static double BALLY = 0;
    public static int ballDirection = 1;
    public static double BALLX = 9;
    public static double speedBoost = 0;
    public static boolean p1pressup, p1pressdown, p2pressup, p2pressdown;
    final static int anim = 10;
    public static int top1 = 0;
    public static int bot1 = 0;
    public static int top2 = 0;
    public static int bot2 = 0;
    public static int side1 = 0;
    public static int side2 = 0;
    public static double theta = ((Math.random())*89);
    public static double yAngle = 0;
    public static boolean restart = true;
    public static int reverser = 1;
    public static double increment = 0;
    public static boolean hey = false; public static boolean ho = false;

    final static String[] scoreLocations = {"images\\score0.png", "images\\score1.png", "images\\score2.png", "images\\score3.png", "images\\score4.png", "images\\score5.png", "images\\score6.png", "images\\score7.png", "images\\score8.png", "images\\score9.png", "images\\score10.png"};
    final static String[] winBanners = {"images\\p1win.png", "images\\p2win.png"};
    public static BufferedImage[] p1scores = new BufferedImage[11];
    public static BufferedImage[] p2scores = new BufferedImage[11];

    //pongPanel's constructor. Takes four images and registers them, telling the compiler "YO. WE GON' BE HANDLING THESE MOFOS."
    public pongPanel(BufferedImage a, BufferedImage b, BufferedImage c, BufferedImage d) {
        p1 = a;
        p2 = b;
        bord = c;
        objective = d;
        p1pressup = false;
        p1pressdown = false;
        p2pressup = false;
        p2pressdown = false;
        //housekeeping~
        setOpaque(true);
        for(int i = 0; i < p1scores.length; i++)
        {
            try {
            p1scores[i] = ImageIO.read(new File(scoreLocations[i]));
            p2scores[i] = ImageIO.read(new File(scoreLocations[i]));
            } catch (Exception e) {System.out.println(":(");}
        }
        try {
        p1win = ImageIO.read(new File(winBanners[0]));
        p2win = ImageIO.read(new File(winBanners[1]));
        } catch (Exception e) {System.out.println(":(");}
    }

    protected void paintComponent(Graphics g) {
        //so this is a weird method, but basically this is how we get our images drawn to the screen
        //we can move our images by modifying the x and y fields (p2y, borderx, etc.)
        //since they're static, this is pretty easy :D
        super.paintComponent(g);
        g.drawImage(p1, P1X, P1Y + p1Move, this);
        g.drawImage(p2, P2X, P2Y + p2Move, this);
        g.drawImage(bord, BORDERX, BORDERY, this);
        g.drawImage(p1scores[p1score], 110, -15, this);
        g.drawImage(p2scores[p2score], 430, -15, this);
        g.drawImage(objective, ballX, ballY+(int)BALLY, this);
        if(hey)
            g.drawImage(p1win, -70, 170, this);
        if(ho)
            g.drawImage(p2win, -70, 170, this);
        //System.out.println("Drawing ball at "+(ballY+(int)BALLY));
    }

    public static double getInc(int i)
    {
        int checker = 0;
        if(i == 2)
            checker = bot2 - (ballY+(int)BALLY+8);
        else
            checker = bot1 - (ballY+(int)BALLY+8);
        if(checker > 0 || checker < 140)
            return 2;
        if(checker > 20 || checker < 120)
            return 1.5;
        if(checker > 40 || checker < 100)
            return 1;
        if(checker > 60 || checker < 80)
            return .5;
        if(checker > 68 || checker < 72)
            return .25;
        return 0;
    }

    public void animate() {
        if(!startScreen.isVis && !hey && !ho) {
            try {

            if(restart)
            {
                yAngle = 0; speedBoost = 0; theta = (Math.random()*89); increment = 0; BALLY = 0; ballX = 210; p1Move = 0; p2Move = 0; reverser = 1;
                if(ballDirection == 0)
                {
                    ballX = 375;
                }
                else
                    ballX = 210;
                repaint();
                restart = false;
                Thread.sleep(1600);
            }

            if(p1pressup && p2pressup) {
                if(P1Y + p1Move > 10)
                    p1Move -= 6;
                if(P2Y + p2Move > 10)
                    p2Move -= 6;
            }
            else if(p1pressdown && p2pressdown) {
                if(P1Y + p1Move < 285)
                    p1Move += 6;
                if(P2Y + p2Move < 285)
                    p2Move += 6;
            }
            else if(p1pressdown && p2pressup) {
                if(P1Y + p1Move < 285)
                    p1Move += 6;
                if(P2Y + p2Move > 10)
                    p2Move -= 6;
            }
            else if(p1pressup && p2pressdown) {
                if(P1Y + p1Move > 10)
                    p1Move -= 6;
                if(P2Y + p2Move < 285)
                    p2Move += 6;
            }
            else if(p1pressup) {
                if(P1Y + p1Move > 10)
                    p1Move -= 6;
            }
            else if(p1pressdown) {
                if(P1Y + p1Move < 285)
                    p1Move += 6;
            }
            else if(p2pressup) {
                if(P2Y + p2Move > 10)
                    p2Move -= 6;
            }
            else if(p2pressdown) {
                if(P2Y + p2Move < 285)
                    p2Move += 6;
            }

            //System.out.println(yAngle);
            double newTheta = (Math.toRadians(theta));
            yAngle = ((4*(Math.sin(newTheta)))*(reverser))+increment;
            BALLY += yAngle;

            //balldirection = 1 goes to the right
            //balldirection = 0 goes to the left
            if(ballX + 16 < 620 && ballDirection == 1)
            {
                ballX += (int)(BALLX + speedBoost);
            }
            if(ballX + 16> side2 && (ballY+(int)BALLY+16 >= top2 && ballY+(int)BALLY <= bot2) && ballDirection == 1)
            {
                //collision with paddle!
                //System.out.println("Col Right");
                theta += getInc(2);
                ballDirection = 0;
                speedBoost += .3;
            }
            if(ballX + 16 >= 620 && ballDirection == 1)
            {
                //ball out of bounds, player 1 point increase
                //System.out.println("OoB Right");
                restart = true;
                p1score++;
                //ballDirection = 0;
            }
            if(ballX >= 0 && ballDirection == 0)
            {
                ballX -= (int)(BALLX + speedBoost);
            }
            if(ballX <= side1 && (ballY+(int)BALLY+16 >= top1 && ballY+(int)BALLY <= bot1) && ballDirection == 0)
            {
                //collision with paddle!
                //System.out.println(ballX + " " + side1);
                //System.out.println(ballY + 16 + " " + top1);
                //System.out.println(ballY + " " + bot1);
                //System.out.println("Col Left");
                speedBoost += .3;
                theta += getInc(1);
                ballDirection = 1;
            }
            if(ballX <= 0 && ballDirection == 0)
            {
                //ball out of bounds, player 2 point increase
                //System.out.println("OoB Left");
                restart = true;
                p2score++;
                //ballDirection = 1;
            }
            if(ballY + BALLY <= 0)
            {
                //System.out.println("OUT");
                reverser *= (-1);
            }
            if((ballY + BALLY + 16) >= 435)
            {
                reverser *= (-1);
                //System.out.println("OUT");
            }
            
            repaint();
            Thread.sleep(anim);
            top1 = P1Y + p1Move;
            top2 = P2Y + p2Move;
            side1 = P1X + 12;
            side2 = P2X;
            bot1 = (P1Y + p1Move) + 142;
            bot2 = (P2Y + p2Move) + 142;

            //System.out.println(top1);
            //System.out.println(bot1);
        }
        catch(InterruptedException e) {System.out.println(":(");}
        }
        else
        {
            repaint();
        }
    }
}