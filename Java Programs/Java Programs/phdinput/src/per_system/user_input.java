package per_system;

import java.awt.Color;

import javax.swing.ImageIcon;


public class user_input extends Gui2{
	public user_input(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void PeterPref() {
		populate.setBackground(Color.green);
		submit.setForeground(Color.magenta);
		temp = "Your temperature is set at 55 degrees";
		voice = "You have selected holly as a voice";
		greeting = "Alright dudes";
		voicelabel.setText(voice);
		templabel.setText(temp);
		greetinglabel.setText(greeting);
	}

	
}
