import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class Calculator {
/**
* @param args
*/
//public static void main(String[] args) {
// TODO Auto-generated method stub
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
JButton button10;
JButton button11;
JButton button12;
JButton button13;
JButton buttonPoint;
JButton buttonEqual;
JPanel pl;
Calculator() {
windowContent = new JPanel(); BorderLayout bl = new
BorderLayout ();
windowContent.setLayout(bl); displayField = new JTextField(30);
windowContent.add("North", displayField);
button0=new JButton("0"); button1=new JButton("1"); button2=new
JButton("2"); button3=new JButton("3"); button4=new JButton("4");
button5=new JButton("5"); button6=new JButton("6"); button7=new
JButton("7"); button8=new JButton("8"); button9=new JButton("9");
button10=new JButton("+"); button11=new JButton("-"); button12=new JButton("/"); button13=new JButton("*");   
buttonPoint = new JButton("."); buttonEqual = new JButton("=");
JPanel pl = new JPanel();
GridLayout gl = new GridLayout (5,4); pl.setLayout(gl);
pl.add(button1);
pl.add(button2);
pl.add(button3);
pl.add(button10);
pl.add(button4);
pl.add(button5);
pl.add(button6);
pl.add(button11);
pl.add(button7);
pl.add(button8);
pl.add(button9);
pl.add(button12);
pl.add(button0);
pl.add(button13);
pl.add(buttonPoint);
pl.add(buttonEqual);
windowContent.add("Center",pl);
JFrame frame = new JFrame("Calculator");
frame.setContentPane(windowContent); frame.pack();
frame.setVisible(true);
}
public static void main (String[] args) { Calculator calc = new
Calculator();
}
}