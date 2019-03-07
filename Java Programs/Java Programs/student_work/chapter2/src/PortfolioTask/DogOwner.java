package PortfolioTask;

public class DogOwner extends Dog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog1 = new Dog ();
		
		dog1.setlegs(4);
		dog1.setfur("furry");
		dog1.settail(true);
		
	
	System.out.println("This dog has " + dog1.legs + " legs");
	System.out.println("Does this dog have a tail? " + dog1.tail);
	System.out.println("This dog has " + dog1.fur + " fur");
}}
 