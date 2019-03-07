
public class DiceRoller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dice1;
		int dice2;
		int total;
		
		dice1 = (int)(Math.random()*6)+1;
		dice2 = (int)(Math.random()*6)+1;
		total = dice1 + dice2;
		
		System.out.println("Dice one is " + dice1);
		System.out.println("Dice one is " + dice2);
		System.out.println("The total is " + total);
	}

}
