package Alanna;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {

	Calculator parent;
	char SelectedAction = ' ';
	double currentResult = 0;

	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e){
		JButton clickedButton = (JButton) e.getSource();
		String dispFieldText = parent.displayField.getText();
		double displayValue=0;

		if(!"".equals(dispFieldText)){
			displayValue=Double.parseDouble(dispFieldText);

		}
		Object src = e.getSource();

		if (src == parent.buttonPlus){
			SelectedAction = '+';
			currentResult=displayValue; 
			parent.displayField.setText("");

		}else if (src== parent.buttonMinus)
		{SelectedAction = '-';
		currentResult=displayValue;
		parent.displayField.setText("");

		}else if (src== parent.buttonDivide) 
		{SelectedAction = '/';
		currentResult=displayValue; parent.displayField.setText("");

		}else if (src== parent.buttonTimes) {SelectedAction = '*';
		currentResult=displayValue;  parent.displayField.setText("");

		}else if (src== parent.buttonClear) {SelectedAction = 'C';
		currentResult=displayValue;  parent.displayField.setText("");

		}else if (src== parent.buttonClearEntirely) {SelectedAction = 'E';
		currentResult=displayValue;  parent.displayField.setText("");

		}else if (src== parent.buttonSquareroot) {SelectedAction = 'q';
		currentResult=displayValue; parent.displayField.setText("");

		}else if (src== parent.buttonPercentage) {SelectedAction = '%';
		currentResult=displayValue; parent.displayField.setText("");

		}else if (src== parent.buttonBackspace) {SelectedAction = 'b';
		currentResult=displayValue; parent.displayField.setText("");

		}else if (src== parent.buttonPlusMinus) {SelectedAction = 'n';
		currentResult=displayValue; parent.displayField.setText("");

		}else if (src== parent.buttonGraph) {SelectedAction = 'x';
		currentResult=displayValue; parent.displayField.setText("");

		}else if (src == parent.buttonEqual){


			if (SelectedAction=='+'){ 
				currentResult +=displayValue;

				parent.displayField.setText(""+currentResult );

			}else if (SelectedAction=='-'){ currentResult -=displayValue;

			 parent.displayField.setText(""+currentResult); }
			else if (SelectedAction=='/'){
				currentResult /=displayValue;

				parent.displayField.setText(""+currentResult); }
			else if (SelectedAction=='*'){

				 parent.displayField.setText(""+currentResult); }
			else if (SelectedAction=='C'){

				parent.displayField.setText(""+currentResult); }
			else if (SelectedAction=='e'){

				 parent.displayField.setText(""+currentResult); }
			else if (SelectedAction=='q'){
				Math.sqrt(currentResult);
				parent.displayField.setText(""+currentResult );
			}	
			else if (SelectedAction=='%'){
				 parent.displayField.setText(""+currentResult); }
			else if (SelectedAction=='b'){

				parent.displayField.setText(""+currentResult); }
			else if (SelectedAction=='n'){

				 parent.displayField.setText(""+currentResult); }
			else if (SelectedAction=='x'){

	
			}
		}else{
			String clickedButtonLabel= clickedButton.getText(); 
			parent.displayField.setText(dispFieldText + clickedButtonLabel);
		} 

	}
}
