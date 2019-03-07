package portfolioTask;
//imports the scanner utility from the library
import java.util.Scanner;

public class TwelveDOC {
	private static Scanner myscan;

	public static void main(String[]args){
		//

		//String created here to store the suffix to be applied to the day.
		String dayEnd;
		//scannerValue variable used to store value entered by user
		int scannerValue;
		myscan = new Scanner(System.in);
		//prints 'enter number'
		System.out.print("Enter Number ");
		//takes value entered by user and stores it in scannerValue variable
		scannerValue = myscan.nextInt();
		//returns the number entered by user.
		System.out.print("Number entered is " + scannerValue);

		//number variable contains integer value which will be used for the for loop...


		System.out.println();


		String xmasThings[]= new String[12];
		//String array used for each of the lines of the song.
		xmasThings[0]="a partridge in a pear tree \r";
		xmasThings[1]="two turtle doves \r";
		xmasThings[2]="three french hens \r";
		xmasThings[3]="four calling birds \r";
		xmasThings[4]="five gold rings \r";
		xmasThings[5]="six geese a-laying \r";
		xmasThings[6]="seven swans a-swimming \r";
		xmasThings[7]="eight maids a-milking \r";
		xmasThings[8]="nine ladies dancing \r";
		xmasThings[9]="ten lords a-leaping \r";
		xmasThings[10]="eleven pipers piping \r";
		xmasThings[11]="twelve drummers drumming \r";


		//Begin for loop
		//For loop states that if the index is less than the value in the number variable, increment.
		for(int i=1; i<=scannerValue; i++){//Begin for loop
			//if value stored in i equals one, append 'st'
			if(i==1){
				dayEnd = "st";

				//else if two, append 'nd'	
			}else{if(i==2){
				dayEnd = "nd";

				//else if three, append 'rd'
			}else{if(i==3){
				dayEnd = "rd";
				//else append 'th' to the remaining values.
			}else{
				dayEnd = "th";

			}
			}}
			/*Print out here concatenates 'on the' string with the value contained in i, the suffix 
			 * stored in dayEnd variable, and 'day of Christmas my true love gave to me' string.
			 */
			System.out.println("On the " + i + dayEnd + " day of Christmas my true love gave to me" );

			/*Final output prints out the line of the song, dependent on the value stored in i
			(minus one so that it corresponds correctly with the day).*/
			System.out.println(xmasThings[i-1]);



		}//ends for loop

























	}//End main
}//End class
