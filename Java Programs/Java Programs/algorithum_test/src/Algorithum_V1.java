import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Image;
import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Algorithum_V1 extends JFrame implements ActionListener {
    static final String gapList[] = {"0", "10", "15", "20","30","40"};
    static final String namelist[] = {"Peter", "John"};
    final static int maxGap = 100;
    JComboBox horGapComboBox;
    JComboBox verGapComboBox;
    JButton applyButton = new JButton("Apply gaps");
    GridLayout experimentLayout = new GridLayout(2,1);
    GridLayout text_layout = new GridLayout(6,3);
    private Image image = null;
    private Image image2 = null;
    private JLabel display = new JLabel();
    public int width = 300;
    public int height = 300;
    public JFormattedTextField health = new JFormattedTextField("Enter your state of health here");
    public JFormattedTextField name = new JFormattedTextField("Enter your name here");
    public JFormattedTextField heartrate = new JFormattedTextField("Ente your heartrate here");
   // public JPanel output = new JPanel;
    public String health_store;
    public String name_store = "";
    public String heart_store;
    public int horGap = 200;
    public int verGap = -200;
    public JButton submit_btn;
    public JButton can_btn;
    boolean image_true ;
    public JButton image_blue = new JButton ("Blue");
    public JButton image_jelly = new JButton ("Jelly");;
    public JButton submit = new JButton ("Submit");;
    
    
    
    public Algorithum_V1(String name) {
        super(name);
        setResizable(false);
            //set images here
        image = getToolkit().getImage("Z:/Java Programs/PhDInput/src/Bluehills.jpg");
        System.out.println("Size: " + image.getWidth(this) + 
                            " by " + image.getHeight(this));
        
        image2 = getToolkit().getImage("Z:/Java Programs/PhDInput/src/Jellyfish.jpg");
        System.out.println("Size: " + image.getWidth(this) + 
                            " by " + image.getHeight(this));
        
    	             
        }
    	
    	   
    
    
    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        final JPanel background = new JPanel();
        final JPanel text = new JPanel();
        final JPanel buttons = new JPanel();
        JPanel controls = new JPanel();
        JPanel imagePanel = new JPanel();
        
        compsToExperiment.setLayout(experimentLayout);
        imagePanel.setLayout(new GridLayout(0,1));
        controls.setLayout(new GridLayout(2,3));
      //  imagePanel.setPreferredSize();
        //Set up components preferred size
        
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
       // setSize(height, width);
        background.add(compsToExperiment);
        compsToExperiment.setPreferredSize(new Dimension((int)(300),((int)(300))));
        display.setPreferredSize(new Dimension((int)(300),(int)(100)));
        
        //Add buttons to experiment with Grid Layout
        if (image_true == true){
        display.setIcon(new ImageIcon(image));
        }else {
        display.setIcon(new ImageIcon(image2));
        }
        
    
        
        compsToExperiment.add(text);
        text.setLayout(text_layout);
        text.add(health);
        text.add(name);
        text.add(heartrate);
        text.add(image_blue);
        text.add(image_jelly);
        text.add(submit);

        
        experimentLayout.setHgap(horGap);
        experimentLayout.setVgap(verGap);
		
        //Add controls to set up horizontal and vertical gaps
        controls.add(new Label("Horizontal gap:"));
        controls.add(new Label("Vertical gap:"));
        controls.add(new Label(" "));
        controls.add(applyButton);
        
        imagePanel.add(display);
        
        //Process the Apply gaps button press
        applyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Get the horizontal gap value
                String horGap = (String)horGapComboBox.getSelectedItem();
                //Get the vertical gap value
                String verGap = (String)verGapComboBox.getSelectedItem();
                //Set up the horizontal gap value
                experimentLayout.setHgap(Integer.parseInt(horGap));
                //Set up the vertical gap value
                experimentLayout.setVgap(Integer.parseInt(verGap));
                //Set up the layout of the buttons
                experimentLayout.layoutContainer(compsToExperiment);
            }
        });
        pane.add(background, BorderLayout.EAST);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(imagePanel, BorderLayout.WEST);
        pane.add(controls, BorderLayout.SOUTH);
        pane.add(buttons, BorderLayout.SOUTH);
        
        image_blue.addActionListener(this);
		image_jelly.addActionListener(this);
		submit.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if (src == submit){
			health_store = health.getText();
			name_store = name.getText();
			heart_store = heartrate.getText();
			
			
			Map<String, String> logins = new HashMap<String, String>();
			logins.put("mark", "pass");
			logins.put("susan", "word");
			logins.put("bobo", "password");

			String username = name_store;
			String password = heart_store;

			if (logins.containsKey(username) && logins.get(username).equals(password)) {
			    System.out.println("KNown Loggin"+username);
			} else {
				System.out.println("Unknown Loggin"+" Error...");
			}
			
			/**if (namelist[0].equals(name_store)&& heart_store.equals("85")) {
			System.out.println("Name is" +namelist[0]+name_store);
			display.setIcon(new ImageIcon(image));
		 }else if (namelist[1].equals(name_store)&& heart_store.equals("85")) {
				System.out.println("Name is" +namelist[0]+name_store);
				display.setIcon(new ImageIcon(image2));
	    
			}
			**/

		
		}if (src == image_jelly){
			javax.swing.JOptionPane.showConfirmDialog(null,
					 "Comparing...", 
					 "Template error",
							javax.swing.JOptionPane.PLAIN_MESSAGE);; 
	    	
	    	
	    	display.setIcon(new ImageIcon(image2));
	    }else {
		
		}
	    }
	    
		
    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        Algorithum_V1 frame = new Algorithum_V1("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);  
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	}
