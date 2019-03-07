
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class calculatorengine implements ActionListener {
	CalculatorNew parent;
	char selectedAction = ' ';
	double currentResult=0;
	
	calculatorengine(CalculatorNew parent) {
		this.parent = parent;
	}

	
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String displayFieldText = parent.displayField.getText();
		
		double displayValue=0;
		
		if (!"".equals(displayFieldText))
		{displayValue=Double.parseDouble(displayFieldText);
		}
		Object src = e.getSource();
		
		if (src == parent.buttonPlus){selectedAction = '+';
		currentResult=displayValue;
		parent.displayField.setText("");
		
		} else if (src == parent.buttonMinus){selectedAction = '-';
		currentResult=displayValue;
		parent.displayField.setText("");
		
		} else if (src == parent.buttonDiv){selectedAction = '/';
		currentResult=displayValue;
		parent.displayField.setText("");
		
		} else if (src == parent.buttonMult){selectedAction = '*';
		currentResult=displayValue;
		parent.displayField.setText("");
		
		} else if (src ==parent.buttonEqual){
			
			if (selectedAction =='+') {
				currentResult+=displayValue;
				parent.displayField.setText(""+currentResult);
			} else if (selectedAction =='-') {
					currentResult-=displayValue;
					parent.displayField.setText(""+currentResult);
			} else if (selectedAction=='/') {				
				if(displayValue==0){
					parent.displayField.setText("Math Error");
				}
				else {
					currentResult /=displayValue;
					parent.displayField.setText(""+currentResult);}
				} else if (selectedAction=='*'){
					currentResult*=displayValue;
					parent.displayField.setText(""+currentResult);
				}else{
					String clickedButtonLable=clickedButton.getText();
					
					if (clickedButtonLable.equals(".")){
							int point = displayFieldText.indexOf(".");
					
					if (point>0){System.out.println("you cant another decimal point");
					} else {
						parent.displayField.setText(displayFieldText + clickedButtonLable);}
					}else { 
						parent.displayField.setText(displayFieldText + clickedButtonLable);
					}
						
				}
			}
		}
		
	}

	

