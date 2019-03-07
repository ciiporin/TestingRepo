
public class PetOwner extends Pet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String petResponse;
		Pet myPet = new Pet();
		myPet.eat();
		myPet.say("Woof Woof");
		
		petResponse = myPet.say("Woof! Woof!! ") ;
		System.out.println(petResponse);
	}

}
