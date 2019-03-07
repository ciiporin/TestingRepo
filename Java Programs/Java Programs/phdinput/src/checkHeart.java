import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class checkHeart { 
	inputTest bloodCheck = new inputTest();
public static int bp;
public static String bloodstring="";
public static void main( String args[] ) {
// create a input stream reader connected to 
// System.in, and pass it to the buffered reader
	BufferedReader stdin = new BufferedReader
			 (new InputStreamReader(System.in));
		
// Keep diving until the user presses "Q"
	while (true) {
	  System.out.println("Please enter your heartrate");
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
				int sum; // sum of number1 and number2

				System.out.println("Enter first integer: " ); // prompt
				number1 = input.nextInt(); // read first number from user

				System.out.print( "Enter second integer: " ); // prompt
				number2 = input.nextInt(); // read second number from user

				sum = number1 + number2; // add numbers

				System.out.printf( "Sum is: " + sum ); // display sum
				
			}
	  // Convert the feetString into an integer and
	  // Dive according to the value of variable feet
		 
	      }
	   } catch (IOException e) {
			e.printStackTrace();
	   }
	 } // End while

	
	

	}
}
