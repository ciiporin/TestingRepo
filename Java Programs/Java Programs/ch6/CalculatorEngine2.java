import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CalculatorEngine2 implements ActionListener {

// Empty method called by JVM		
		
	public void actionPerformed(ActionEvent e){
	JOptionPane.showConfirmDialog(null,
			"Something Happened...",
			"Just a test",
			JOptionPane.PLAIN_MESSAGE);
	}

}
