import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Running {
	
	public static void colorrun (){
		ColorSensor light = new ColorSensor(SensorPort.S2);
	    UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S1);
	    DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.B, true);

		while (true) {
		      LCD.drawInt(light.getColorID(), 4, 0, 0);
		      LCD.drawInt(ultra.getDistance(), 4,0,1);
		 if ((ultra.getDistance() < 10)){
			 System.out.println("testing"+ultra.getDistance());
			 Motor.C.setSpeed(50);
			 Motor.C.rotate(-30);
			// Motor.B.backward();
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Motor.B.rotate(30);
			 
		 } else {
			
		 }
		 
		if (light.getColorID() == 6){
			pilot.setTravelSpeed(2);
			pilot.backward();
		}else if (light.getColorID()== 0){
			pilot.stop();
			Motor.C.rotate(30);
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Sound.buzz();
			pilot.rotate(480);
			pilot.backward(); 
     		}else if (light.getColorID()==7){
			pilot.stop();
			Motor.C.stop();
			Sound.beepSequence();
			
     		break;
			
			}
		}
		}
		
	
		 public static void main(String[] args){
    
			 
			 colorrun();
			 Button.waitForPress();

    
     
    }
  }
