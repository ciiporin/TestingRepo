import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

/**
 * Robot stops if it hits something before it completes its travel.
 */
public class NewLevel5 {
	static DifferentialPilot pilot;
	TouchSensor bump = new TouchSensor(SensorPort.S2);
	ColorSensor color = new ColorSensor(SensorPort.S1);
	UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);

	public void reverse() {
		Motor.C.backward();
		Motor.B.backward();
		while (pilot.isMoving()) {
			if (bump.isPressed())
				pilot.stop();
		}
		System.out.println("Robot Has Stopped Reversing");
	}

	public void go() {

		while (/*sonic.getDistance() == 255*/true) {
			System.out.println("Testing");
			if (sonic.getDistance() <= 10) {

				System.out.println("Distance of object is"
						+ sonic.getDistance());

				Motor.A.rotate(-35);
				pilot.forward();
			/*	while (pilot.isMoving()) {
					 if (color.getColorID() == 2) {
						pilot.stop();
						Motor.A.rotate(30);
					 }else if (bump.isPressed()){
								pilot.stop();

						}else{
						}
						 
				}*/
				}
			else if (sonic.getDistance() <50) {		
				System.out.println("Fall through");
							pilot.forward();
							while (pilot.isMoving()) {
								if (color.getColorID() == 1) {
									pilot.stop();
									Motor.A.rotate(-35);
									Motor.C.rotate(2000);
									reverse();
								}else if (color.getColorID() != 1) {			
									//while (sonic.getDistance() == 255) {
									//	Motor.B.rotate(215);
							   // pilot.forward();

										/*	while (pilot.isMoving()) {
												if (color.getColorID() == 2) {
													pilot.stop();*/

													
												}
											}
										}else {
											Motor.C.rotate(10);

										}
									}
								
							
						
					
				
			
		
	}

	public static void main(String[] args) {
		NewLevel5 traveler = new NewLevel5();
		traveler.pilot = new DifferentialPilot(2f, 2f, Motor.B, Motor.C);
		traveler.pilot.setTravelSpeed(5);
		TouchSensor bump = new TouchSensor(SensorPort.S2);
		ColorSensor color = new ColorSensor(SensorPort.S1);
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);

		 traveler.go();
		while (true) {

			System.out.println("Distance is: " + sonic.getDistance());
		}

	}

}
