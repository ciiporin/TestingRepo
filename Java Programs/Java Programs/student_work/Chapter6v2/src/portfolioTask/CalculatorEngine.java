package portfolioTask;
//imports actionEvent and ActionListener
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;


public class CalculatorEngine implements ActionListener {

	Calculator parent; // reference to the calculator itself

	char selectedAction = ' '; // operator

	double currentResult = 0;
	
	// NEW flag to tell us whether the
	// contents of the textbox are a result.
	Boolean displayingResult = false; 

	// Constructor stores the reference to the calculator

	// window in the member variable parent
	CalculatorEngine(Calculator parent) {

		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		// get the source of this action
		//(casts this to JButton)
		JButton clickedButton = (JButton) e.getSource();
		//gets the string from displayField
		String dispFieldText = parent.displayField.getText();

		Boolean hasPoint = false; // NEW flag to tell us if the displayField contains
									// a decimal point already.
		//double used as opposed to int (allows decimal points).
		double displayValue = 0;

		// get the number from the text field if it's not empty

		if (!"".equals(dispFieldText)) {

			displayValue = Double.parseDouble(dispFieldText);
		}

		Object src = e.getSource();

		// for each action button, memorise selected

		// action +,-,/ or *, store the current value

		// in the currentResult, and clean up the display

		// field for entering the next number

		if (src == parent.buttonAdd) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");

		} else if (src == parent.buttonSubt) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");

		} else if (src == parent.buttonDiv) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");

		} else if (src == parent.buttonMult) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");

		// UNARY OPERATORS
			// NEW These operators are unary, they only operate on one operand,
			// so they are evaluated immediately
			

		} else if (src == parent.buttonSqrt){
			displayingResult = true;
			currentResult = Math.sqrt(displayValue);
			parent.displayField.setText(""+currentResult);
			
			//NEW implementation of +- button
			
		} else if (src == parent.buttonChangeSign){
			displayingResult = true;
			//instead of using math.abs, simply state the displayValue with '-' before it.
			currentResult = -displayValue;
			parent.displayField.setText("" + currentResult);

		}// NEW implementation of reciprocal function
		else if (src == parent.buttonRecip) {
			displayingResult = true;
			currentResult = 1f / displayValue;
			parent.displayField.setText("" + currentResult);

		}// NEW implementation of percentage function
		else if (src == parent.buttonPerc) {
			displayingResult = true;
			currentResult = displayValue / 100;
			parent.displayField.setText("" + currentResult);
		}
		// END UNARY OPERATORS
		
		
		// CLEAR BUTTONS
		// NEW clear buttons implemented.
		else if (src == parent.buttonC) {
			//if the text in displayField is greater then 0, set text to blank
			if (dispFieldText.length() > 0)
				parent.displayField.setText("");
			//sets currentResult to 0 if CE is pressed.
		} else if (src == parent.buttonCE) {
			parent.displayField.setText("");
			currentResult = 0;
//if the text in the displayfield is greater than 0, convert string to substring
//starting from index 0, and deduct 1 from the substring's length.
		} else if (src == parent.buttonBackspace) {
			if (dispFieldText.length() > 0)
				parent.displayField.setText(dispFieldText.substring(0,
						dispFieldText.length() - 1));
			

		} // END CLEAR BUTTONS

		else if (src == parent.buttonEqual) {

			// perform calculations based on selectedAction
			// update the value of the variable currentResult
			// and display the result

			if (selectedAction == '+') {
				currentResult += displayValue;
				// convert the result to string by concatenating
				// to an empty string and display it
				parent.displayField.setText("" + currentResult);

			} else if (selectedAction == '-') {
				currentResult -= displayValue;
				parent.displayField.setText("" + currentResult);

			} else if (selectedAction == '/') {
				currentResult /= displayValue;
				parent.displayField.setText("" + currentResult);

			} else if (selectedAction == '*') {
				currentResult *= displayValue;
				parent.displayField.setText("" + currentResult);

			} 
			
			// reset relevant values, so pressing buttons doesn't give strange
			// results. '\0' is a null char.
			displayingResult = true;
			selectedAction = '\0';
			

		}

		// NEW added decimal point functionality

		else if (src == parent.buttonPoint) {

			hasPoint = dispFieldText.contains("."); // NEW only display one
													// decimal point.
			if (!hasPoint) {
				selectedAction = '.';
				currentResult = displayValue;
				parent.displayField.setText("" + (int) currentResult
						+ selectedAction); // NEW cast to int before adding
											// point.

				// if it doesn't already have a point, it has to be an int -
				// avoids getting 0.0. or similar
			}

		} else {
			// for all numeric buttons append the button's
			// label to the text field
			String clickedButtonLabel = clickedButton.getText();
			if (displayingResult) // NEW If we've already displayed a result,
									// clicking a number should start a new
									// calculation.
				parent.displayField.setText("");
			parent.displayField.setText(parent.displayField.getText()
					+ clickedButtonLabel);
		}
		
	}

}