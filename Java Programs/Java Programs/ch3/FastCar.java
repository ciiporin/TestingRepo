

public class FastCar extends Car {
	
	public int distance;
	public int fuelUsed ;
	public int mph;
	
	
	public int speed(int maxSpeed, int time, int Startingfuel){
		distance = maxSpeed / time;
		
		System.out.println("You have travelled " + distance + " miles, in " + time + " seconds");
		
		fuelUsed = time / distance;
		
		System.out.println("You started with " + Startingfuel + " units of fuel, and have used " + fuelUsed  + " units of fuel");
		
				
		return maxSpeed;
		
		

	
		
}
}
