
public class Players2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		String Players[] = {"David","Daniel","Anna","Greg"};
		int totalPlayers = Players.length;
		
		while (counter < totalPlayers)
		{
			counter++;
			String thePlayer = Players[counter];
			if (thePlayer.equals("David"))
			{
				continue;
			}
			System.out.println("Congratulations, " + thePlayer);
			//counter++;
		}
	}
}
