package Players;

public class Players {
	/**
	 * @param arg
	 */
public static void main(String[]args) {
	int counter=0;
	
	String Players[] = {"David", "Daniel", "Anna", "Gregory"};
	int totalPlayers = Players.length;
	
		while(counter< totalPlayers) {
			counter++;
								
		
		String thePlayer = Players[counter];
		
		if(thePlayer.equals("David")) {
			continue;
		}
		System.out.println("Congratulations," + thePlayer + "!");
		
		
	}
}
}