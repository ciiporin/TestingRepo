package TestPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
	
	Calculator parent;
	char selectedAction = ' '; //+ - * /
	
	double currentResult = 0;
	
	CalculatorEngine(Calculator parent){
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
			JButton clickedButton = (JButton)e.getSource();
			String dispFieldText = parent.displayField.getText();
			double displayValue = 0;
			
			//Get the number from the text field if it is not empty
			
			if (!"".equals(dispFieldText)) {
				displayValue = Double.parseDouble(dispFieldText);
			}
			Object src = e.getSource();
			
			//Memorise action, store value, then clean up the text field
			
			if (src == parent.buttonPlus) {selectedAction = '+';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonPlus) {selectedAction = '-';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonPlus) {selectedAction = '*';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonPlus) {selectedAction = '/';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonClearAll) {selectedAction = '!';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonClear) {selectedAction = 'C';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonPercentage) {selectedAction = '%';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonSquareRoot) {selectedAction = '#';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonOneSlashX) {selectedAction = '~';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			else if (src == parent.buttonClear) {selectedAction = 'C';
			currentResult = displayValue; parent.displayField.setText("");
			}
			
			
			
			else if (src == parent.buttonEqual) {
				
				//perform calculation based on selectedAction and display it in currentResult
			
				if (selectedAction == '+') {
					currentResult += displayValue;
					
					//Concatenated to an empty string
					
					parent.displayField.setText(""+currentResult);
					
				}else if (selectedAction == '-') {
					currentResult -= displayValue;
						
					parent.displayField.setText(""+currentResult);
						
				}else if (selectedAction == '*') {
					currentResult *= displayValue;
							
					parent.displayField.setText(""+currentResult);
							
				}else if (selectedAction == '/') {
					currentResult /= displayValue;
								
					parent.displayField.setText(""+currentResult);
				}
			} else {
				//append the buttons label to the text field
				
				String clickedButtonLabel = clickedButton.getText();
				parent.displayField.setText(dispFieldText + clickedButtonLabel);
			}
			
			
			
		}
}


