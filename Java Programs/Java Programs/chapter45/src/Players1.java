
public class Players1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		String Players[] = {"David","Daniel","Anna","Greg"};
		int totalPlayers = Players.length;
		
		while (counter < totalPlayers)
		{
			if (counter == 3)
			{
				break;
			}
			String thePlayer = Players[counter];
			System.out.println("Congratulations, " + thePlayer);
			counter++;
		}
	}

}
