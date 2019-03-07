/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
public class PetMaster {
	public static void main(String[] args) {
		String petReaction;	

		Pet mydog = new Pet();
		Pet mycat = new Pet();
		
		
		mydog.eat();
		mydog.dance();
		mydog.bark();
		mydog.sleep();
		petReaction = mydog.say("Nice seeing you!");
		//mydog.say("Bark!! Bark!!");
		System.out.println(petReaction);
		
		
/*

	   Pet myPet = new Pet();

	   myPet.eat();
	   
	   myPet.dance();
	   myPet.sleep();
	*/  
	  }
}
