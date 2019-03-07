package TestPack;

//Here I'm starting out by importing all the necessary components that I'll be using to create the calculator. 
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

//I'm then creating a class, within which I'm creating a lot of objects that are part of the afforementioned set of components.
public class Calculator {
	JPanel windowContent;
	JTextField displayField;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton buttonPlus;
	JButton button4;
	JButton button5; 
	JButton button6;
	JButton buttonMinus;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonMultiply;
	JButton buttonPoint;
	JButton buttonEqual;
	JButton buttonDivide;
	JButton buttonClear;
	JButton buttonClearAll;
	JButton buttonBackspace;
	JButton buttonPercentage;
	JButton buttonOneSlashX;
	JButton buttonSquareRoot;
	JPanel pl;

//I'm setting the border and layout as well as defining strings that will be ascribed to the above defined objects.
	Calculator() {
		windowContent = new JPanel();
		BorderLayout bl = new BorderLayout ();
		
		windowContent.setLayout(bl); 
		displayField = new JTextField(30);
		
		windowContent.add("North", displayField);	
		
		button0 = new JButton("0"); 
		button1 = new JButton("1");
		button2= new JButton("2"); 
		button3 = new JButton("3");
		buttonPlus = new JButton("+"); 
		button4 = new JButton("4");
		button5 = new JButton("5"); 
		button6 = new JButton("6");
		buttonMinus = new JButton("-");
		button7 = new JButton("7"); 
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonMultiply = new JButton("*");
		buttonPoint = new JButton("."); 
		buttonEqual = new JButton("=");
		buttonDivide = new JButton("/");
		buttonClearAll = new JButton("CE");
		buttonClear = new JButton ("C"); 
		buttonOneSlashX = new JButton ("1/x");
		buttonSquareRoot = new JButton ("sqrt");
		buttonPercentage = new JButton("%"); 
		buttonBackspace = new JButton ("Backspace");
		
//I create 'pl' here so that I can later use that to add my buttons to the JPanel called 'pl'
		
		JPanel pl = new JPanel();
		GridLayout gl = new GridLayout (4, 3); 
		pl.setLayout(gl);
		
//Here I'm just adding all the previously defined buttons so they show up on the calculator when it runs
		
		pl.add(button1);
		pl.add(button2);
		pl.add(button3);
		pl.add(button4);
		pl.add(button5);
		pl.add(button6);
		pl.add(button7);
		pl.add(button8);
		pl.add(button9);
		pl.add(button0);
		pl.add(buttonPoint);
		
		
		windowContent.add("Center", pl);
		
		JPanel p2 = new JPanel();
		//Creating a 5 button layout in a column rather than 4 to fit in the Clear button.
		GridLayout g1 = new GridLayout(5,1);
		p2.setLayout(g1);
		p2.add(buttonClearAll);
		p2.add(buttonPlus);
		p2.add(buttonMinus);
		p2.add(buttonMultiply);
		p2.add(buttonDivide);
		
		
		windowContent.add("West", p2);
		
		//Creating a third JPanel for the Clear,
		
		JPanel p3 = new JPanel();
		
		gl = new GridLayout(5,1);
		p3.setLayout(gl);
		p3.add(buttonClear);
		p3.add(buttonSquareRoot);
		p3.add(buttonOneSlashX);
		p3.add(buttonPercentage);
		p3.add(buttonEqual);
		
		windowContent.add("East", p3);

		JFrame frame = new JFrame ("Calculator");
		frame.setContentPane(windowContent); 
		
		frame.pack();
		
		frame.setVisible(true);
	

	
		
		
	//Here I'm just creating a Calculator in the main that will run all the above code
	
	CalculatorEngine calcEngine = new CalculatorEngine(this);
	    
	    button1.addActionListener(calcEngine);
	    button2.addActionListener(calcEngine);
	    button3.addActionListener(calcEngine);
	    button4.addActionListener(calcEngine);
	    button5.addActionListener(calcEngine);
	    button6.addActionListener(calcEngine);
	    button7.addActionListener(calcEngine);
	    button8.addActionListener(calcEngine);
	    button9.addActionListener(calcEngine);
	    button0.addActionListener(calcEngine);
	    
	    buttonPoint.addActionListener(calcEngine);
	    buttonEqual.addActionListener(calcEngine);
	    buttonPlus.addActionListener(calcEngine);
	    buttonMinus.addActionListener(calcEngine);
	    buttonDivide.addActionListener(calcEngine);
	    buttonMultiply.addActionListener(calcEngine);
	    
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	
}

