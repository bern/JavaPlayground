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
import java.awt.CardLayout;

public class pong extends JFrame{

    //declaring image locations and the bufferedimages
    final static String[] imageLocations = {"images\\paddle.png", "images\\ball.png", "images\\border.png"};
    private static BufferedImage leftPaddle, rightPaddle, border, ball;
    public static pongPanel gameWindow;
    public static startScreen startWindow;

    public class keyPresses implements KeyListener {
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_K:
                    //System.out.println("Up arrow pressed.");
                    //gameWindow.repaint();
                    pongPanel.p2pressup = true;
                    break;
                case KeyEvent.VK_M:
                    //System.out.println("Down arrow pressed.");
                    //gameWindow.repaint();
                    pongPanel.p2pressdown = true;
                    break;
                case KeyEvent.VK_A:
                    //System.out.println("A key pressed.");
                    //gameWindow.repaint();
                    pongPanel.p1pressup = true;
                    break;
                case KeyEvent.VK_Z:
                    //System.out.println("Z key pressed.");
                    //gameWindow.repaint();
                    pongPanel.p1pressdown = true;
                    break;
                default:
                    //System.out.println("Well a key was pressed...");
            }
        }

        public void keyReleased(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_K:
                    //System.out.println("Up arrow released.");
                    pongPanel.p2pressup = false;
                    break;
                case KeyEvent.VK_M:
                    //System.out.println("Down arrow released.");
                    pongPanel.p2pressdown = false;
                    break;
                case KeyEvent.VK_A:
                    //System.out.println("A key released.");
                    pongPanel.p1pressup = false;
                    break;
                case KeyEvent.VK_Z:
                    //System.out.println("Z key released
                    pongPanel.p1pressdown = false;
                    break;
                default:
                    //System.out.println("Well a key was released...");
            }
        }

        public void keyTyped(KeyEvent e)
        {}
    }

    //private class MyDispatcher implements KeyEventDispatcher {
      //  @Override
        //public boolean dispatchKeyEvent(KeyEvent e) {
          //  if (e.getID() == KeyEvent.KEY_PRESSED) {
            //    System.out.println("A is pressed");
            //}
            //} else if (e.getID() == KeyEvent.KEY_RELEASED) {
             //   System.out.println("2test2");
            //} //else if (e.getID() == KeyEvent.KEY_TYPED) {
              //  System.out.println("3test3");
            //}
            //return false;
       // }
    //}

    public pong(String s)
    {
        //super(s) makes s the title of our JFrame
        super(s);

        //bufferedimage initializations have to be in a try-catch block in case a url doesn't exist
        try{
            //christ, what a convoluded command. Reading in a new file that's based off the url stored in imageLocations
            leftPaddle = ImageIO.read(new File(imageLocations[0]));
            rightPaddle = ImageIO.read(new File(imageLocations[0]));
            border = ImageIO.read(new File(imageLocations[2]));
            ball = ImageIO.read(new File(imageLocations[1]));
        } catch(Exception e) {System.out.println("Image not found :(");}

        //creats a JPanel from the class pongPanel using the 4 parameters. Those basically become the images we will be manipulating
        gameWindow = new pongPanel(leftPaddle, rightPaddle, border, ball);
        startWindow = new startScreen();

        //if we were to try to set the JFrame's background to black, the JPanel would cover it. We remedy this by simply making the JPanel's background black
        gameWindow.setBackground(Color.BLACK);

        //and we are in business!
        
        add(gameWindow);
        add(startWindow);
    }

    public void checkMovement()
    {
        gameWindow.animate();
    }

    public void addKey()
    {
        gameWindow.addKeyListener(new keyPresses());
        gameWindow.requestFocus();
    }

    //the actual starting point of the game
    public static void main(String[] args)
    {
        int i = 0;
        pong newPong = new pong("PONG");
        newPong.setSize(640,480);
        newPong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newPong.setVisible(true);
        while(startScreen.isVis)
        {i = 0;System.out.print("");}
        newPong.startWindow.setVisible(false);
        newPong.add(gameWindow);
        newPong.addKey();
        while(true) {
            newPong.checkMovement();
            if(pongPanel.p1score == 10)
            {
                pongPanel.hey = true;
                pongPanel.ballX = 700;
                newPong.checkMovement();
                break;
            }
            if(pongPanel.p2score == 10)
            {
                pongPanel.ho = true;
                pongPanel.ballX = 700;
                newPong.checkMovement();
                break;
            }
        }

    }
}

