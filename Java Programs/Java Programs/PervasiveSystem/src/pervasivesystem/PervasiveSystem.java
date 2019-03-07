/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pervasivesystem;

/**
 *
 * @author matthewp
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PervasiveSystem implements ActionListener {

    private JFrame frame;
    
    private static void GUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("SimpleGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("I am a label");
        JLabel label1 = new JLabel("I am a label2");
        frame.getContentPane().add(label, BorderLayout.NORTH);
        frame.getContentPane().add(label1, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(250,250);
        
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        fileMenu.addActionListener(this);
        JMenu openItem = new JMenu("Open");
        menubar.add(openItem);
        JMenu quitItem = new JMenu("Quit");
        menubar.add(quitItem);
        JMenu helpItem = new JMenu("Help");
        menubar.add(helpItem);
       
        JMenuItem about = new JMenuItem ("About");
       helpItem.add(about) ;
        
       JButton button = new JButton("I'm a button!");
       JButton button1 = new JButton("I'm a button2!");
       frame.getContentPane().add(button, BorderLayout.SOUTH);
       frame.getContentPane().add(button1, BorderLayout.WEST);
       button.setBackground(Color.GREEN);
       frame.setBackground(Color.YELLOW);
       label.setBackground(Color.YELLOW);
       button1.setBackground(Color.BLUE);
    }
        /**
     * @param args the command line arguments
     */
    
    public void actionperformed(ActionEvent event){
        System.out.println("Item: "+ event.getActionCommand());
        
    }
    public static void main(String[] args) {
        PervasiveSystem show = new PervasiveSystem();
        show.GUI();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}

