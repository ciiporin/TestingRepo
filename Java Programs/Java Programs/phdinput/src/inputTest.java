import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*; 
import java.lang.Object;

public class inputTest {
	public static String bloodstring=""; //bloodstring is current bloodrate
	public static String currentRate="";//currentRate is what current average is
	public static int sum; // sum of number1 and number2
	public static int setHeart; // first number to add
	 

	  public static void main(String[] args) {
		  ArrayList hearttest = new ArrayList();
		  
			
		   inputTest bloodCheck = new inputTest();
		   int bp;
		   // create a input stream reader connected to 
		   // System.in, and pass it to the buffered reader
			BufferedReader stdin = new BufferedReader
					 (new InputStreamReader(System.in));
				
		  
			while (true) {
			  System.out.println("Please select one of the following options:");
			  System.out.println("1. Press 'S' to set hour heartrate goal");
			  System.out.println("2. Press 'M' to check your heartrate");
 			  System.out.println("3. Press 'P' to show your heartrates todate");
 			  System.out.println("4. Press 'Q' to quit this program");
 			  //hearttest.add("Test");
			  //System.out.println(hearttest);
			  try {
				bloodstring = stdin.readLine();
				if (bloodstring.equals("Q")){
				// Exit the program
		  		  System.out.println("Good bye!");
				  System.exit(0);
				}else {
					if (bloodstring.equals("M")){
						
						Scanner input = new Scanner( System.in );

						int number1; // first number to add
						int number2; // second number to add
					

						System.out.println("Enter first integer: " ); // prompt
						number1 = input.nextInt(); // read first number from user

						System.out.print( "Enter second integer: " ); // prompt
						number2 = input.nextInt(); // read second number from user

						sum = (number1 + number2)/2; // add numbers
						hearttest.add(sum);

						System.out.printf( "Sum is %d\n", sum ); // display sum	
						
						if(sum > setHeart)
						System.out.println("Your heart rate is higher than your set max " + sum +"/"+setHeart);		
										
						}
						
						
			  // Convert the feetString into an integer and
			  // Dive according to the value of variable feet
				
			      
				else{
					if(bloodstring.equals("S")) {
						System.out.println("Enter in your ideal Heartrate");
						Scanner input1 = new Scanner( System.in );

						setHeart = input1.nextInt();
						System.out.println("Your heartrate has been set to: "+setHeart);
					}
			
						else{
							if(bloodstring.equals("P")) {
								System.out.println("Your hearts to-date"+hearttest);
								
							}
					}
					}
					
				}
				}
			  
				 catch (IOException e) {
					e.printStackTrace();
			   }
			 } // End while
	

		  } // End main

	private static void checkHeart() {
		
		if (bloodstring.equals("Q")){
			// Exit the program
	  		  System.out.println("Good bye!");
			  System.exit(0);
	}
	  
	}
}


