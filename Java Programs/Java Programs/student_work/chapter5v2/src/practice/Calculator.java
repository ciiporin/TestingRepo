package practice;
//imports Java swing
import javax.swing.*;

//imports layout managers
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;


public class Calculator {
//declares objects to be used by the program

	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonPoint;
	JButton buttonEqual;
	JButton buttonAdd;
	JButton buttonSubt;
	JButton buttonMult;
	JButton buttonDiv;
	
	//new buttons for portfolio task
	JButton buttonBackspace;
	JButton buttonChangeSign; //+- changes sign of number from positive to negative, and vice versa
	JButton buttonCE; //CE button clears the last entry on the calculator
	JButton buttonC; //C button clears everything
	JButton buttonSqrt; //sqrt button for square root
	JButton buttonRecip; //1/x is a reciprocal button - puts whatever in the calculator into a fraction, top will be 1,
						//other value will be what's on the calculator.
	JButton buttonPerc; //percentage button
	JPanel windowContent;
	JTextField displayField;
	JPanel pl;
	JPanel pl2;
	
	
	
	
Calculator() {//Constructor

	
	
		windowContent = new JPanel();
		//creates new border layout
		BorderLayout bl = new BorderLayout();
		//sets JPanel to border layout
		windowContent.setLayout(bl);
		//creates new JTextfield (30 characters)
		displayField = new JTextField(30);
		
		//sets this text field to the north of JPanel
		windowContent.add(displayField, "North");

		//creating the buttons and operators for calculator
		button0 = new JButton("0");
 		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonPoint = new JButton(".");
		buttonEqual = new JButton("=");
		buttonAdd = new JButton("+");
		buttonSubt  = new JButton("-");
		buttonMult  = new JButton("*");
		buttonDiv= new JButton("/");
		//new buttons
		buttonBackspace = new JButton("Backspace");
		buttonChangeSign = new JButton("+-");
		buttonCE = new JButton("CE");
		buttonC = new JButton("C");
		buttonSqrt = new JButton("sqrt");
		buttonRecip = new JButton("1/x");
		buttonPerc = new JButton("%");
		
		//Variable bigFont used to store font change, to be applied
		//to main panel buttons.
		Font bigFont;
		bigFont = new Font("Arial", Font.BOLD, 30);
		
//		-------------------------------------------------------------------
//		---------------------Panel 1---------------------------------------
		
		//creates new panel for numbers and two operators
		JPanel pl = new JPanel();
		//sets grid dimensions for main panel to five rows by four columns.
		//sets horizontal and vertical spacing to 5 and 5 respectively
		GridLayout gl = new GridLayout(5,4,5,5);
		pl.setLayout(gl);
		//empty border added to put space around edges of components (top, left,
		//bottom, right.
		pl.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		//sets vertical spacing between components
		gl.setVgap(10);
		
		//adds numbers and 2 operators to this panel
		//applies 'bigFont' variable to these buttons.
		
		pl.add(button7);
		button7.setFont(bigFont);
		pl.add(button8);
		button8.setFont(bigFont);
		pl.add(button9);
		button9.setFont(bigFont);
		pl.add(button4);
		button4.setFont(bigFont);
		pl.add(button5);
		button5.setFont(bigFont);
		pl.add(button6);
		button6.setFont(bigFont);
		pl.add(button1);
		button1.setFont(bigFont);
		pl.add(button2);
		button2.setFont(bigFont);
		pl.add(button3);
		button3.setFont(bigFont);
		pl.add(button0);
		button0.setFont(bigFont);
		pl.add(buttonChangeSign);
		buttonChangeSign.setFont(bigFont);
		pl.add(buttonPoint);
		buttonPoint.setFont(bigFont);
		pl.add(buttonBackspace);
		
		//centres this panel
		windowContent.add("Center", pl);
		//creates a new frame and titles it 'calculator'
		JFrame frame = new JFrame("Oisac Calculator V1.0");
		//sets the content to be included in the window content panel
		frame.setContentPane(windowContent);
		//contracts the window so that it fits with its contents.
		frame.pack();
		//shows this frame
		frame.setVisible(true);
		
	//	-----------------------------------------------------------------
	//	-------------------------MENU------------------------------------
		
		//Adds the menu bar with "file" and "help" as selectables.
		JMenuBar menuBar = new JMenuBar();
		//puts the menubar at the top of the frame
		frame.setJMenuBar(menuBar);
		
		//new submenu item "File"
		JMenu file = new JMenu("File");
		//adds "file" to the menu bar
		menuBar.add(file);
		//adds another menu item "Exit" below "File"
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		
		//adds "Help" to the menu bar
		JMenu help = new JMenu("Help");	
		menuBar.add(help);
		//adds "About" below "Help"
		JMenuItem about= new JMenuItem("About");
		help.add(about);
//		--------------------------------------------------------------
//		------------------------END MENU------------------------------
//		-----------------------END PANEL 1----------------------------
		
		
//		---------------------PANEL 2----------------------------------
//		--------------------------------------------------------------
		
		// creates panel for remaining  operators
		JPanel pl2 = new JPanel();
		//sets constraints for the grid to be four rows by one column.
		//sets horizontal and vertical spacing to 5 and 5 respectively.
		GridLayout gl2 = new GridLayout(5, 2, 5, 5);
		//sets layout to grid
		pl2.setLayout(gl2);
		//adds empty border to the elements in this panel
		pl2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 30));
		//adds operator buttons to panel
		pl2.add(buttonCE);
		pl2.add(buttonC);
		pl2.add(buttonDiv);
		pl2.add(buttonSqrt);
		pl2.add(buttonMult);
		pl2.add(buttonRecip);
		pl2.add(buttonSubt);
		pl2.add(buttonPerc);
		pl2.add(buttonAdd);
		pl2.add(buttonEqual);
		//sets panel to align to the right.
		windowContent.add("East", pl2);
		//sets the content to be included in the window content panel
		frame.setContentPane(windowContent);
		//wraps pane around all of the content
		frame.pack();
		//shows this frame
		frame.setVisible(true);
//		---------------------END PANEL 2------------------------------
//		--------------------------------------------------------------
	
		//instantiate the event listener and
		//register each button with it
		
		CalculatorEngine calcEngine = new CalculatorEngine(this);
		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);
		button5.addActionListener(calcEngine);
		button6.addActionListener(calcEngine);
		button7.addActionListener(calcEngine);
		button8.addActionListener(calcEngine);
		button9.addActionListener(calcEngine);
		//regular operators
		buttonPoint.addActionListener(calcEngine);
		buttonEqual.addActionListener(calcEngine);
		buttonAdd.addActionListener(calcEngine);
		buttonSubt.addActionListener(calcEngine);
		buttonMult.addActionListener(calcEngine);
		buttonDiv.addActionListener(calcEngine);
		//new operators
		buttonBackspace.addActionListener(calcEngine);
		buttonCE.addActionListener(calcEngine);
		buttonC.addActionListener(calcEngine);
		buttonSqrt.addActionListener(calcEngine);
		buttonRecip.addActionListener(calcEngine);
		buttonPerc.addActionListener(calcEngine);
		buttonChangeSign.addActionListener(calcEngine);
		
	
	}//ends calculator constructor
	//Creates an instance of the code contained in the Calculator constructor 
	public static void main (String[] args) {
Calculator calc = new Calculator();
	
		
	}//ends main	
	
}//ends class

