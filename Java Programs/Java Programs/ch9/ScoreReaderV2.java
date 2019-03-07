import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;



public class ScoreReaderV2 {


		public static void main(String[] args) {
			FileReader myFile = null;
			BufferedReader buff = null;
			try {
				myFile = new FileReader("MyFile.txt");
				buff = new BufferedReader(myFile);

				while (true) {
					// Read a line from scores.txt
					String line = buff.readLine();

					// Check for end of file
					if (line == null) 
						break;
					System.out.println(line);
				} // End of the while loop

			}catch (IOException e) {
				System.out.print ("Could not read file:" + e.toString ());

			}finally{
				try{
					buff.close();
					myFile.close();
				} catch (Exception el) { 
					el.printStackTrace();
				}
				System.out.println("Finished reading the file");			
			}}}
