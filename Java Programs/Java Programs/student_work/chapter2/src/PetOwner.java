
public class PetOwner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String petResponse;
		
		Pet myPet = new Pet();
		
		myPet.eat();
		petResponse = myPet.say("Woof! Woof!");
		System.out.println(petResponse);
		
		myPet.sleep();
	}

}
