package Alanna;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator {
	
/**
* @param args
*/
Container windowContent;
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
JButton buttonMinus;
JButton buttonTimes;
JButton buttonDivide;
JButton buttonPlus;
JButton buttonClear;
JButton buttonClearEntirely;
JButton buttonSquareroot;
JButton buttonPercentage;
JButton buttonBackspace;
JButton buttonPlusMinus;
JButton buttonGraph;
JButton buttonFile;
JButton buttonHelp;
JPanel pl;
JPanel p2;
JPanel p3;
JPanel p4;



Calculator() {
windowContent = new JPanel(); BorderLayout bl = new BorderLayout ();
windowContent.setLayout(bl); displayField = new JTextField(10);
windowContent.add("North", displayField);

button0=new JButton("0"); 
button1=new JButton("1"); 
button2=new JButton("2"); 
button3=new JButton("3"); 
button4=new JButton("4");
button5=new JButton("5"); 
button6=new JButton("6"); 
button7=new JButton("7"); 
button8=new JButton("8"); 
button9=new JButton("9");
buttonPoint = new JButton("."); 
buttonEqual = new JButton("=");
buttonMinus = new JButton ("-");
buttonTimes = new JButton ("*");
buttonDivide = new JButton ("/");
buttonPlus = new JButton ("+");
buttonClear = new JButton ("C");
buttonClearEntirely = new JButton ("CE");
buttonSquareroot = new JButton ("sqrt");
buttonPercentage = new JButton ("%");
buttonBackspace = new JButton ("Backspace");
buttonPlusMinus = new JButton ("+/-");
buttonGraph = new JButton ("1/x");
buttonFile = new JButton ("File");
buttonHelp = new JButton ("Help");



JPanel pl = new JPanel();
JPanel p2 = new JPanel ();
JPanel p3 = new JPanel ();
JPanel p4 = new JPanel ();

GridLayout gl = new GridLayout (4,4); pl.setLayout(gl);
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
pl.add(buttonEqual);

GridLayout g2 = new GridLayout (4,4); p2.setLayout(g2);
p2.add(buttonMinus);
p2.add(buttonTimes);
p2.add(buttonDivide);
p2.add(buttonPlus);


GridLayout g3 = new GridLayout (4,4); p2.setLayout(g3);
p3.add(buttonClear);
p3.add(buttonClearEntirely);
p3.add(buttonSquareroot);
p3.add(buttonPercentage);
p3.add(buttonBackspace);
p3.add(buttonPlusMinus);
p3.add(buttonGraph);

GridLayout g4 = new GridLayout (4,4); p2.setLayout(g4);
p4.add(buttonFile);
p4.add(buttonHelp);


windowContent.add("Center",pl);
windowContent.add("East",p2);
windowContent.add("South",p3);
//windowContent.add("North",p4);

JFrame frame = new JFrame("Calculator");
frame.setContentPane(windowContent); frame.pack();
frame.setVisible(true);

CalculatorEngine  calcEngine = new CalculatorEngine(this);


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

buttonPoint.addActionListener(calcEngine); 
buttonPlus.addActionListener(calcEngine); 
buttonMinus.addActionListener(calcEngine); 
buttonDivide.addActionListener(calcEngine); 
buttonTimes.addActionListener(calcEngine); 
buttonEqual.addActionListener(calcEngine);
buttonMinus.addActionListener(calcEngine);
buttonTimes.addActionListener(calcEngine);
buttonDivide.addActionListener(calcEngine);
buttonClear.addActionListener(calcEngine);
buttonClearEntirely.addActionListener(calcEngine);
buttonSquareroot.addActionListener(calcEngine);
buttonPercentage.addActionListener(calcEngine);
buttonBackspace.addActionListener(calcEngine);
buttonPlusMinus.addActionListener(calcEngine);
buttonGraph.addActionListener(calcEngine);
buttonFile.addActionListener(calcEngine);
buttonHelp.addActionListener(calcEngine);


	}

public static void main (String[] args) {
	Calculator calc = new Calculator();
}
} 
	



