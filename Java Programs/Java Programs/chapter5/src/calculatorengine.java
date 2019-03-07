import
java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class calculatorengine
							implements ActionListener {
	
	Calculator parent; // a reference to calculator window
	char selectedAction = ' '; //  +, -, /, or *
	
	double currentResult =0;
	
	//Constructor stores the reference to the Calculator
	//window in the member variable parent
	calculatorengine(Calculator parent) {
		
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e){
		//get the source of this action
		JButton clickedButton = (JButton) e.getSource();
		//set existing text from the calculator's
		//display field
		String dispFieldText = parent.displayField.getText();
		double displayValue=0;
		
		//get the number from the text field
		//if its not empty
		if (!"".equals(dispFieldText)){
			displayValue= Double.parseDouble(dispFieldText);
		}
		Object src = e.getSource();
		//for each action button memorise selected
		//action +, -, /, or *. store the current value
		//in the currentResult, and clean up the display
		//field for entering the next number
		
		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult=displayValue;
			parent.displayField.setText("" );
		}
		else if (src == parent.buttonMinus) {
			selectedAction = '-';
			currentResult=displayValue;
			parent.displayField.setText("" );
		}
				else if (src == parent.buttonDivide) {
			selectedAction = '/';
			currentResult=displayValue;
			parent.displayField.setText("" );
		}
		else if (src == parent.buttonMultiply) {
			selectedAction = '*';
			currentResult=displayValue;
			parent.displayField.setText("" );
		}
		else if (src == parent.buttonEqual){
			//Perform the calculations based on selectedAction
			//update the value of the variable currentResult
			//and display the result
			if (selectedAction=='+'){
				currentResult+=displayValue;
				//convert the result to string by concatenating
				//to an empty string and display it
				parent.displayField.setText(""+currentResult);
			}
			else if (selectedAction=='-'){
				currentResult -=displayValue;
				parent.displayField.setText(""+currentResult);
			}
			else if (selectedAction=='/'){
				currentResult /=displayValue;
				parent.displayField.setText(""+currentResult);
			}
			else if (selectedAction=='*'){
				currentResult *=displayValue;
				parent.displayField.setText(""+currentResult);
			}
			else {
				//for all numeric buttons append the button's
				//label to the text field
				String clickedButtonLabel= clickedButton.getText();
				parent.displayField.setText(dispFieldText + clickedButtonLabel);	
			}
		}
}}

	