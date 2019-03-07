
public class Car {
	public int distance;
	public int age;
	public int totalspeed;
	public String model;
	public String color;
	

public void start(){
	System.out.println("The car has started");
	
}

public void stop(){
	System.out.println("The car has stopped");
	
}
public void model(){
	model = ("Three Wheeler");
	System.out.println("The car is a " + model);

}
public int drive (int howlong){
	int distance = howlong*180;
	int totalspeed = distance/1500*60;
	System.out.println("The distance traveld is " +distance + " in 60 Seconds!");
	System.out.println("The overall MPH is " +totalspeed + " MPH!");
		
return howlong;
		
}
}








