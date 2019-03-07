package portfolioTask;

//In order to use the scanner, it has to be imported from the java library
import java.util.Scanner;
//Begins class
public class TwelveDOCOriginal {
	//Begins main
	public static void main(String[]arg){
		//scannerValue variable stores the value entered by the user in the scanner
		int scannerValue;
		//String variable used to store suffix, appended to specific day.
		String dayEnd;
		/*New string array with twelve elements, stated in square brackets.
		 * Each day has a \r (carriage return), which moves the cursor to the beginning of the next line
		 */
		String [] daysofXmas = new String [12];
		daysofXmas[0]="and a partridge in a pear tree \r";
		daysofXmas[1]="two turtle doves \r";
		daysofXmas[2]="three french hens \r";
		daysofXmas[3]="four calling birds \r";
		daysofXmas[4]="five gold rings \r";
		daysofXmas[5]="six geese a-laying \r";
		daysofXmas[6]="seven swans a-swimming \r";
		daysofXmas[7]="eight maids a-milking \r";
		daysofXmas[8]="nine ladies dancing \r";
		daysofXmas[9]="ten lords a-leaping \r";
		daysofXmas[10]="eleven pipers piping \r";
		daysofXmas[11]="twelve drummers drumming \r";

		//Creates an instance of the scanner that takes user input
		Scanner myscan = new Scanner(System.in);
		//prints 'enter number'
		System.out.print("Enter Number ");
		//takes value entered by user and stores it in scannerValue variable
		scannerValue = myscan.nextInt();
		//returns the number entered by user.
		System.out.print("Number entered is " + scannerValue);
		System.out.println();

		//For loop that iterates dependent on the value entered into the scanner by the user.
		for(int i=1; i<=scannerValue;i++){
			//if i is equal to 1, do the following code;
			if(i==1){
				//changes the dayEnd string variable
				dayEnd="st";

				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println("a partridge in a pear tree \r");

				//if i is equal to 2, do the following code;
			}else{if(i==2){
				//changes dayEnd variable to "nd"
				dayEnd="nd";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[1]+daysofXmas[0]);

				//if i is equal to 3 do the following code;
			}else{if(i==3){
				//changes dayEnd variable to "rd"
				dayEnd="rd";
				//Use of concatenation to string together the value in i with the dayEnd suffix, wrapped in a generic string, applied to each day.
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

				//if i is equal to 4, do the following code;
			}else{if(i==4){
				//changes dayEnd variable to "th".
				dayEnd="th";
				//use of \r here denotes the printing of a new line after the string. It is essentially a line break.
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				//Final line of each nested if/else statement prints out the stated index (in square brackets), which increments dependent on the day.
				System.out.println(daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}else{if(i==5){
				dayEnd="th";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[4]+daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}else{if(i==6){
				dayEnd="th";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[5]+daysofXmas[4]+daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}else{if(i==7){
				dayEnd="th";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[6]+daysofXmas[5]+daysofXmas[4]+daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}else{if(i==8){
				dayEnd="th";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[7]+daysofXmas[6]+daysofXmas[5]+daysofXmas[4]+daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}else{if(i==9){
				dayEnd="th";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[8]+daysofXmas[7]+daysofXmas[6]+daysofXmas[5]+daysofXmas[4]+daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}else{if(i==10){
				dayEnd="th";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[9]+daysofXmas[8]+daysofXmas[7]+daysofXmas[6]+daysofXmas[5]+daysofXmas[4]+daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}else{if(i==11){
				dayEnd="th";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[10]+daysofXmas[9]+daysofXmas[8]+daysofXmas[7]+daysofXmas[6]+daysofXmas[5]+daysofXmas[4]+daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}else{if(i==12){
				dayEnd="th";
				System.out.print("On the " +i+dayEnd+" day of Christmas my true love gave to me \r");
				System.out.println(daysofXmas[11]+daysofXmas[10]+daysofXmas[9]+daysofXmas[8]+daysofXmas[7]+daysofXmas[6]+daysofXmas[5]+daysofXmas[4]+daysofXmas[3]+daysofXmas[2]+daysofXmas[1]+daysofXmas[0]);

			}}}}}}}}}}}}//ends nested if/else statements
		}//ends for loop

		//Ends the scanner method
		myscan.close();



	}//ends main
}//ends class


