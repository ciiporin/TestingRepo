package portfolioTask;

public class NanExcept extends Exception{
	
	public NanExcept(){
		javax.swing.JOptionPane.showConfirmDialog(null, "Please refrain from "
				+ "entering letters into the calculator", "Wrong input", javax.swing.JOptionPane.PLAIN_MESSAGE);
	}
	
}