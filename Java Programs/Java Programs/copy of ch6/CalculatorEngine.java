/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {

	Calculator parent; // a reference to Calculator window
	char selectedAction = ' '; // +, -, /, or *

	double currentResult = 0;

	// Constructor stores the reference to the Calculator
	// window in the member variable parent
	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		// Get the source of this action
		JButton clickedButton = (JButton) e.getSource();
		String dispFieldText = parent.displayField.getText();

		double displayValue = 0;

		// Get the number from the text field
		// if it’s not empty
		if (!"".equals(dispFieldText)) {
			try {
				displayValue = Double.parseDouble(dispFieldText);
			} catch (NumberFormatException e1) {
				javax.swing.JOptionPane.showConfirmDialog(null,
						"Please Enter A Number", "Wrong Input",
						javax.swing.JOptionPane.PLAIN_MESSAGE);
				return;
			}
		}

		Object src = e.getSource();

		// For each action button memorize selected
		// action +, -, /, or *, store the current value
		// in the currentResult, and clean up the display
		// field for entering the next number
		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMinus) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonDivide) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMultiply) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonRoot) {
			selectedAction = 's';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonClear) {
			selectedAction = 'c';
			currentResult = 0;
			parent.displayField.setText("");
		} else if (src == parent.buttonPercent) {
			selectedAction = '%';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonBack) {
			selectedAction = '<';
			dispFieldText = dispFieldText.substring(0,
					dispFieldText.length() - 1);
			parent.displayField.setText("" + dispFieldText);
		} else if (src == parent.buttonDivOne) {
			selectedAction = '1';
			currentResult = displayValue;
			parent.displayField.setText("");
		
		} else if (src == parent.buttonEqual) {
			// Perform the calculations based on selectedAction
			// update the value of the variable currentResult
			// and display the result

			try {
				if (selectedAction == '+') {
					currentResult += displayValue;
					// Convert the result to String by concatenating
					// to an empty string and display it
					parent.displayField.setText("" + currentResult);
				} else if (selectedAction == '-') {
					currentResult -= displayValue;
					parent.displayField.setText("" + currentResult);
				} else if (selectedAction == '/') {
					if (displayValue == 0)
						throw new DivideByZeroException();
					currentResult /= displayValue;
					parent.displayField.setText("" + currentResult);
				} else if (selectedAction == '*') {
					currentResult *= displayValue;
					parent.displayField.setText("" + currentResult);
				} else if (selectedAction == 's') {
					currentResult = Math.sqrt(currentResult);
					parent.displayField.setText("" + currentResult);
				} else if (selectedAction == '%') {
					currentResult = (currentResult / displayValue) * 100;
					parent.displayField.setText("" + currentResult);
				} else if (selectedAction == '<') {
					currentResult = (currentResult / displayValue) * 100;
					parent.displayField.setText("" + currentResult);
				} else if (selectedAction == '1') {
					currentResult = 1 / currentResult;
					parent.displayField.setText("" + currentResult);
				}
			} catch (DivideByZeroException e2) {
				parent.displayField.setText(e2.getMessage());
				/*javax.swing.JOptionPane.showConfirmDialog(null,
						"Cannot divide by Zero", "Division Error",
						javax.swing.JOptionPane.PLAIN_MESSAGE);
				*/
			}
		} else {
			// For all numeric buttons append the button's
			// label to the text field
			String clickedButtonLabel = clickedButton.getText();
			parent.displayField.setText(dispFieldText + clickedButtonLabel);
		}

	}

}
