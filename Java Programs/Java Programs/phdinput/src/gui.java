import java.awt.Image;
import javax.swing.*;
import java.io.*;

public class gui extends JFrame
{  private Image image = null;
   private JLabel display = new JLabel();
   public JButton testing = new JButton("Testing");
   public JPanel mainArea;
   public JLabel question1 = new JLabel("Question 1");
   public JLabel question2 = new JLabel("Question 2");
   public JLabel question3 = new JLabel("Question 3");
   public gui()
   {  super("Image Test");
      image = getToolkit().getImage("F:/Java Programs/PhDInput/src/Bluehills.jpg");
     // System.out.println("Size: " + image.getWidth(this) + 
                         //  " by " + image.getHeight(this));
      display.setIcon(new ImageIcon(image));
    //mainArea.GridLayout();
   // mainArea.add("North", question1);
    //mainArea.add("North", question2);
    //mainArea.add("North", question3);

     getContentPane().add("East", display);
      getContentPane().add("West", testing);
      validate(); pack(); setVisible(true);
    //  System.out.println("Size: " + image.getWidth(this) + 
              //             " by " + image.getHeight(this));
   }
   public static void main(String args[])
   {  gui sit = new gui(); }
}
