
public class FancyCar extends Car {
	
	/**
	 * @param args
	 */
			public int drive (int howlong){
			int distance = howlong*180;
			int totalspeed = distance/1500*60;
				System.out.println("The distance traveld is " +distance + " in 60 Seconds!");
				System.out.println("The overall MPH is " +totalspeed + " MPH!");
			return howlong;
				
		}
			public void model(){
				model = ("Lotus big Car");
				System.out.println("The car is a " + model);
}
}