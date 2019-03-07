import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

public class ScoreWriter2 {
/**
The method main performs the following actions:
1. Create an instance of array
2. Create Score objects and populate array with them
3. Write the scores data into a file
*/
	public static void main(String[] args) {
		FileWriter myFile = null;
		BufferedWriter buff = null;
		Date today = new Date();
		Score aScore[] = new Score[3];
		// The player #1
		aScore[0]=new Score("John","Smith" , 250, today);
		// The player #2
		aScore[1]= new Score("Anna","Lee" , 300, today);
		// The player #3 
		aScore[2]= new Score("David","Dolittle" , 190, today);
		try{
			myFile = new FileWriter("z:\\scores2.txt"); 
			buff = new BufferedWriter(myFile); 
			for (int i=0; i < aScore.length; i++) { 
				// Convert each of the scores to a String 
				// and write it into scores2.txt 
				buff.write(aScore[i].toString());
				System.out.println("Writing " +
				aScore[i].getLastName() );
			}
			System.out.println("File writing is complete");
		}catch (IOException e){
			e.printStackTrace();
		} finally {
			try{
				buff.flush();
				buff.close();
				myFile.close();
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}}}
