
public class FishMaster {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String petReaction;
		
		fish myFish = new fish();
		
		
		myFish.dive(2);
		myFish.dive(97);
		myFish.dive(3);
		
		myFish.sleep();
		
		petReaction = myFish.say("hello");
		System.out.println(petReaction);
	}

}
