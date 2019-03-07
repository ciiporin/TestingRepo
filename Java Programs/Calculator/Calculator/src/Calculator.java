import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
public class Calculator {

	/**
	 * @param args
	 */
		// TODO Auto-generated method stub
	//the code below defines the buttons that have been created in this class
		JPanel windowContent;
		JTextField displayField;
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
		JButton buttonDivide;
		JButton buttonPlus;
		JButton buttonMultiply;
		JButton buttonMinus;
		JButton buttonC;
		JButton buttonCE;
		JButton buttonSQRT;
		JButton buttonPercentage;
		JButton buttonDot;
		JButton buttonX;
		JButton buttonBackspace;
		JButton buttonPlusMinus;
		JPanel p1;
		//private Container wndowContent;
		
		
		
		
	 Calculator(){
		 windowContent = new JPanel();
		 BorderLayout bl = new  BorderLayout();
			windowContent.setLayout(bl);
			displayField = new JTextField(30);
			windowContent.add("North", displayField); 
			//the code below show all the buttons that have been created for calculator 
			// it also show how they will be displayed by using the brackets and speechmarks
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
			buttonDivide = new JButton("/"); 
			buttonPlus = new JButton("+");
			buttonMultiply = new JButton("*"); 
			buttonMinus = new JButton("-");
			buttonC = new JButton("C"); 
			buttonCE =new JButton("CE"); 
			buttonPercentage = new JButton("%"); 
			buttonDot = new JButton("."); 
			buttonX = new JButton("1/x");
			buttonBackspace = new JButton("Backspace");
			buttonSQRT = new JButton ("sqrt");
			buttonPlusMinus = new JButton ("+/-");
			
			// below is the code that shows a grid in how the buttons will be presented on the calculator
			JPanel pl = new JPanel();
			GridLayout gl = new GridLayout (4,3);
			pl.setLayout(gl);
			pl.add(button1);
			pl.add(button2);
			pl.add(button3);
			pl.add(button4);
			pl.add(button5);
			pl.add(button6);
			pl.add(button7);
			pl.add(button8);
			pl.add(button0);
			pl.add(buttonPoint);
			
		  
		    windowContent.add("Center", pl);
		   JFrame frame = new JFrame("Calculator");
		  frame.setContentPane(windowContent); frame.pack();
		   frame.setVisible(true);
		  // below is the second grid with the task assigned buttons
		  JPanel p2 = new JPanel();
		  GridLayout g2 = new GridLayout(4,1);
		    p2.setLayout(g2);
		    p2.add(buttonEqual);
		    p2.add(buttonDivide);
		    p2.add(buttonPlus);
		    p2.add(buttonMultiply);
		    p2.add(buttonMinus);
		    p2.add(buttonC);
		    p2.add(buttonCE);
		    p2.add(buttonSQRT);
		    p2.add(buttonDot);
		    p2.add(buttonPercentage);
		    p2.add(buttonBackspace);
		    p2.add(buttonPlusMinus);
		    windowContent.add("East",p2);
		    // the code below is an event that is called an action listener. this is linked to CalculatorEngine page 
		    // this ActionLister makes sure that the buttons of the calculator function when they are clicked based on their given rules
		    //ActionListener calcEnginel = null;
		    CalculatorEngine calcEngine1 = new CalculatorEngine(this);
		    
		    button0.addActionListener(calcEngine1);		    
			button1.addActionListener(calcEngine1);
		    button2.addActionListener(calcEngine1);
		    button3.addActionListener(calcEngine1);
		    button4.addActionListener(calcEngine1);	    
		    button5.addActionListener(calcEngine1);
		    button6.addActionListener(calcEngine1);
		    button7.addActionListener(calcEngine1);
		    button8.addActionListener(calcEngine1);
		    button9.addActionListener(calcEngine1);
		    buttonBackspace.addActionListener(calcEngine1);
		    buttonPoint.addActionListener(calcEngine1);
		    buttonPlus.addActionListener(calcEngine1);
		    buttonMinus.addActionListener(calcEngine1);
		    buttonDivide.addActionListener(calcEngine1);
		    buttonMultiply.addActionListener(calcEngine1);
		    buttonEqual.addActionListener(calcEngine1);	
		    buttonPlusMinus.addActionListener(calcEngine1);
		    buttonC.addActionListener(calcEngine1);
		    buttonCE.addActionListener(calcEngine1);
		    buttonPercentage.addActionListener(calcEngine1);
		    buttonSQRT.addActionListener(calcEngine1);
		    
		}
		public static void main (String[] args)
		{
			Calculator calc = new Calculator();
		}
	}
		
		
		
		
