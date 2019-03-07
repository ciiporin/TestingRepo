
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class FileCopier {
	/* Main method */

	public static void main(String[] args) throws IOException {

		String fileName = "Z:\\Scores.txt"; //change this string to refer to a text file on your computer

		String outName = fileName + ".out";

		// CheckFile
		if (!checkFile(fileName)) System.exit(1);

		// Process

		BufferedReader BufferedReaderfileInput = openReadFile(fileName); 

		String text;
		BufferedWriter fileOutput = openWriteFile(outName);
		// Read file and output to write file

		while (true) {
			BufferedReader fileInput = null;
			text = fileInput.readLine();
			System.out.println(text);

			if (text == null)
			{
				System.out.println("testin123");
				break;

			} else {

				fileOutput.write(text);
				fileOutput.flush();

				System.out.println(text);
			}

			// Close file

			fileInput.close();
			fileOutput.close();}
	}



	/*Open read File */

	private static BufferedReader openReadFile(String fileName)
	{ 
		FileReader myFile = null;
		BufferedReader buff = null;
		try {
			myFile = new FileReader("F:\\Liam\\Programming\\L.J.txt");
			buff = new BufferedReader(myFile);
			
	    while (true) {
	    	// Read a line from L.J.txt
	    	String line = buff.readLine();
	    	
	    	// Check for end of file
	    	if (line == null) {
	    		break;
	    	}
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
			}
		return buff;}



		// In this method you will need to create a FileReader and
		// then a BufferedReader. The final line should return the
		// BufferedReader that you have created.
		// HINT: DONT FORGET THE try-catch! 


		/* Open Write File */

		private static BufferedWriter openWriteFile(String fileName)
		{
			int someData[] = {};
			
			FileOutputStream myFile = null;
			BufferedOutputStream buff = null;
			try {
				// Open the file L.J.txt and save
				// the data from the array
				myFile = new FileOutputStream("F:\\Liam\\Programming\\L.J.txt");
				// Connect the streams
				buff = new BufferedOutputStream(myFile);
				
		            for (int i = 0; i < someData.length; i++) {
					buff.write(someData[i]);
				}
			} catch (IOException e) {
				System.out.println("Could not write to file: " + e.toString());
			} finally {
				try {
					buff.flush();
					buff.close();
					myFile.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}


			// In this method you will need to create a FileWriter and
			// then a BufferedWriter. The final line should return the
			// BufferedWriter that you have created.
			// HINT: DONT FORGET THE try-catch! 

			BufferedWriter fileOutput = null;
			return fileOutput;
		}


		/* Check File */

		private static boolean checkFile(String fileName) {

			// In this method you will check whether the file
			// exists and can be accessed

			File src = new File(fileName);
			return false;

			// Create if statement to check the following
			// src.exists() - is the file in the file system
			// src.canRead() - do you have access to the file
			// src.isFile() - is this a file or a directory
			// If all of these are true, then return true
			// otherwise return false and print out a message showing which failed
		}
}
