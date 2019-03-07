package per_system;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//import javax.media.control.FormatControl;
//import javax.media.format.VideoFormat;
public class Gui2 extends JFrame implements ActionListener {

   
        GridLayout experimentLayout = new GridLayout(2, 2);
    GridLayout text_layout = new GridLayout(5, 2);
    private Image image = null;
    private Image image2 = null;
    private JLabel display = new JLabel();
    public int width = 300;
    public int height = 300;
    public JFormattedTextField health = new JFormattedTextField(
            "Enter your state of health here");
    public JFormattedTextField name = new JFormattedTextField("");
    public JFormattedTextField heartrate = new JFormattedTextField("");
    // public JPanel output = new JPanel;
    public String health_store;
    public String name_store = "";
    public String heart_store;
    public int horGap = 200;
    public int verGap = -200;
    public JButton submit_btn;
    public JButton can_btn;
    boolean image_true;
    public JButton image_blue = new JButton("Blue");
    public JButton image_jelly = new JButton("Jelly");
    public static JButton submit = new JButton("Submit");
    JLabel name_label = new JLabel("Enter your name here...");
    JLabel heart_label = new JLabel("Enter your heartrate here...");
    String image_store = new String("");
    public static JButton populate = new JButton("Populate");
    public String username;
    String password;
    String image_store_string;
    String[] image_array = {"Bluehills.jpg", "Jellyfish.jpg", "Koala.jpg"};
    static String temp;
    static String voice;
    static String greeting;
    JLabel templabelTitle = new JLabel("Temprature: ");
    static JLabel templabel = new JLabel("");
    JLabel voiceTitle = new JLabel("Voice Choice: ");
    static JLabel voicelabel = new JLabel("");
    JLabel greetingTitle = new JLabel("Greeting: ");
    static JLabel greetinglabel = new JLabel("");
    JLabel loggin = new JLabel("Connecting...");
    String checknew;

    public Gui2(String name) {
        super(name);
        setResizable(false);
        populate.setEnabled(false);
        image_store = "NoPhoto.jpg";
        image_input();
        // set images here
    }
    //sets the image
    public void image_input() {
        System.out.println("Testin");
        System.out.println(image_store);
        image = getToolkit().getImage(
            		   "//c1staffhome1/STAFFHOME1/Matthewp/Desktop/Other/Java Programs/PhDInput/src/per_system/" + image_store);
            //"C:/Users/Peter/Dropbox/Java Programs/PhDInput/src/per_system/" 
        	//c1staffhome1\STAFFHOME1\Matthewp\Desktop\Other\Java Programs\PhDInput\bin\per_system
        
        System.out.println("Size: " + image.getWidth(this) + " by "
                + image.getHeight(this));
        display.setIcon(new ImageIcon(image));
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        final JPanel background = new JPanel();
        final JPanel text = new JPanel();
        final JPanel buttons = new JPanel();
        JPanel imagePanel = new JPanel();
        
        //setting grid layout for compsTOExperiment and imagePanel
        compsToExperiment.setLayout(new GridLayout(2, 2));
        imagePanel.setLayout(new GridLayout(1, 2));
     

        JButton b = new JButton("");
        Dimension buttonSize = b.getPreferredSize();
        // setSize(height, width);
        background.add(compsToExperiment);
        compsToExperiment.setPreferredSize(new Dimension((int) (200),
                ((int) (200))));
        display.setPreferredSize(new Dimension((int) (300), (int) (400)));
        text.setPreferredSize(new Dimension((int) (400), (int) (400)));
        
        JPanel image_content = new JPanel();
        imagePanel.add(display);

        JPanel p1 = new JPanel();
        JPanel controls = new JPanel();

        controls.add(p1, BorderLayout.EAST);
        controls.add(imagePanel, BorderLayout.NORTH);
        compsToExperiment.add(text);

        p1.setLayout(text_layout);
        p1.add(name_label);
        p1.add(name);
        p1.add(heart_label);
        p1.add(heartrate);
        p1.add(submit);
        p1.add(loggin);
        text.setLayout(text_layout);
        text.add(voiceTitle);
        text.add(voicelabel);
        text.add(greetingTitle);
        text.add(greetinglabel);
        text.add(templabelTitle);
        text.add(templabel);
        //text.add(image_blue);
        //text.add(image_jelly);
        //text.add(submit);
        //text.add(populate);

        populate.setBackground(Color.BLUE);

       

        // Add controls to set up horizontal and vertical gaps

        //imagePanel.add(display);

        //pane.add(background, BorderLayout.EAST);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        //pane.add(imagePanel, BorderLayout.NORTH);
        pane.add(controls, BorderLayout.WEST);
        pane.add(text, BorderLayout.EAST);

        //image_blue.addActionListener(this);
        //image_jelly.addActionListener(this);
        submit.addActionListener(this);
        //populate.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object src = e.getSource();

        if (src == submit) {
            name_store = name.getText();

            Map<String, Object> logins = new HashMap<String, Object>();
            logins.put("Peter", gui_hashtable.pass);
            logins.put("Alan", gui_hashtable.pass);
            logins.put("Bill", gui_hashtable.pass);

            username = name_store;
         

            if (logins.containsKey(username) && logins.get(username).equals(gui_hashtable.pass)) {
                loggin.setText("Welcome " + username);
               image_store = gui_hashtable.image;
                image_input();
                voicelabel.setText(gui_hashtable.voice);
                Color colorArray[] = new Color[0];
                //colorArray[0] = Color.+gui_hashtable.colour();
                //submit.setBackground(colourString);
                System.out.println(image_store);
     
           populate.setEnabled(true);
            } else {
                loggin.setText("Unauthorised user");
            }
        }

    }

    private static void createAndShowGUI() {
        /**
         * Create the GUI and show it. For thread safety, this method is invoked
         * from the event dispatch thread.
         */
        // Create and set up the window.
        Gui2 frame = new Gui2("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        gui_hashtable aScore[] = new gui_hashtable[5];
		// The player #1
		aScore[0]= new gui_hashtable("Peter","85", "Koala.jpg", "Holly", "Red");
		// The player #2
		aScore[1]= new gui_hashtable("Alan","70" , "Jellyfish.jpg", "Kryten", "Brown");
		// The player #3
		aScore[2]= new gui_hashtable("Bill","50" , "Bluehills.jpg", "Lister", "Blue");
        try {
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });

    }
}