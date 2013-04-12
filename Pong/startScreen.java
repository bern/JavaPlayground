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

public class startScreen extends JPanel {
    
    public static String[] menuLocations = {"images\\mainscreen.png", "images\\startbutton.png"};
    BufferedImage main;
    public static int x = 125;
    public static int xInc = 30;
    public static boolean isVis = true;
    public JButton start;

    public class startButton implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            while(x < 780)
            {
                try {
                    Thread.sleep(10);
                } catch (Exception d) {System.out.println(":(");}
                x += xInc;
                start.setBounds(x, (480/2), 373, 76);
                reAdd();
            }
            isVis = false;
        }
    }

    public void reAdd()
    {
        add(start);
    }

    public startScreen()
    {
        try {
        main = ImageIO.read(new File(menuLocations[0]));
        } catch (Exception e) {System.out.println(":(");}
        ImageIcon startImg= new ImageIcon(menuLocations[1]);
        start = new JButton(startImg);
        this.setLayout(null);
        start.setBounds(x, (480/2), 373, 76);
        start.addActionListener(new startButton());
        add(start);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(main, 0, 0, this);
    }
}