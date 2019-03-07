

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener  {
Calculator parent; //a reference to Calculator window 
char selectedAction = ' '; // +, -, /, or *

double currentResult=0;

//	Constructor  stores the reference to the Calculator 
//	window in the member variable parent 
CalculatorEngine(Calculator parent){ 

this.parent = parent;

}

public void actionPerformed(ActionEvent  e){

// Get the source of this action

JButton clickedButton = (JButton) e.getSource(); 
String dispFieldText = parent.displayField.getText();
double displayValue=0;

//Get the number from the text field // if it�s not empty

if (!"".equals(dispFieldText)){
	displayValue = Double.parseDouble(dispFieldText);


}
Object src = e.getSource();

//For each action button memorise  selected 
//action +, -, /, or *, store the current value 
//in the currentResult,  and  clean up the display 
//field for entering the next number 

if(src == parent.buttonPlus){
	selectedAction = '+';
	currentResult = displayValue;
	parent.displayField.setText("");
} else if(src == parent.buttonMinus){
	selectedAction = '-';
	currentResult = displayValue;
	parent.displayField.setText("");
} else if(src == parent.buttonDivide){
	selectedAction = '/';
	currentResult = displayValue;
	parent.displayField.setText("");
} else if(src == parent.buttonMultiply){
	selectedAction = '*';
	currentResult = displayValue;
	parent.displayField.setText("");
} else if (src == parent.buttonDot){
	selectedAction = '.';
	currentResult=displayValue; 
	parent.displayField.setText("");
//}else if (src == parent.buttonPercentage){
//	selectedAction = '%';
//currentResult=displayValue;
//parent.displayField.setText("");
} else if (src ==parent.buttonSQRT){
	currentResult =displayValue;
	currentResult = Math.sqrt(currentResult);
	parent.displayField.setText(""+currentResult);
	// this button functions by revealing any number's square root that is entered into the calculator
}else if (src == parent.buttonC){
	currentResult = 0;
	displayValue = 0;
	parent.displayField.setText("");
	//this button deletes everything that has and was entered on the calculator
}else if (src==parent.buttonBackspace){
	String currentValue = parent.displayField.getText();
	String newValue = currentValue.substring(0, currentValue.length()-1);
// this the backspace button, it deletes the last value on the calculator by examining the length of the values
	//and then removing the last value and returning the remaining values.
	parent.displayField.setText(newValue);
} if (src==parent.buttonPlusMinus){
	currentResult = displayValue;
	if(currentResult > 0){
		currentResult = 0 - currentResult;
		parent.displayField.setText(""+currentResult);
	}else if(currentResult < 0){
		currentResult = 0 + currentResult;
		parent.displayField.setText(""+currentResult);
		// this button add any value that is less than zero and add numbers that are greater than the value zero
	}

}else if(src == parent.buttonCE){
	currentResult = 0;
	displayValue =0;
	parent.displayField.setText(""+currentResult);
	// this button deletes the last entered value from the calculator

} else if (src == parent.buttonEqual){ 	

//Perform the calculations based on selectedAction 
//update the value of the variable currentResult 
//and display the result 

if (selectedAction=='+'){ 
	currentResult +=displayValue;
	parent.displayField.setText(""+currentResult);

//Convert the result to String by concatenating 
//to an empty string and display it 

}else if (selectedAction=='-'){ 
	currentResult -=displayValue;
	parent.displayField.setText(""+currentResult); 
	}
else if (selectedAction=='/'){
currentResult /=displayValue;
parent.displayField.setText(""+currentResult); 
}
 else if (selectedAction=='%'){
	currentResult = (displayValue * currentResult)/100;
	parent.displayField.setText(""+currentResult);
	// this button ensure that percentage is returned by dividing the entered number by 100 and returning the outcome as an answer
}
else if (selectedAction=='*'){
currentResult*=displayValue; 
parent.displayField.setText(""+currentResult);

} 

} else {

//	For all numeric buttons append the button's 
//	label to the text field 

String clickedButtonLabel = clickedButton.getText(); 
parent.displayField.setText(dispFieldText + clickedButtonLabel);
}
//try {
	
	//displayValue=Double.parseDouble(dispFieldText);

	//file.read (); }catch(Exception e){

	//printStackTrace();

	//}finally{(!"".equals(dispFieldText))

//		the code that must always be executed 

//		goes here, for example file.close(); 

	}

}