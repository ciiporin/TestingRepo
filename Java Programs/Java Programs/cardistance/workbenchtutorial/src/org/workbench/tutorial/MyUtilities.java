package org.workbench.tutorial;

import java.io.*;

public class MyUtilities {

	/**
	 * Saves string to a text file.
	 * 
	 * @param fileName Name of output text file.
	 * @param saveString String to write to file.
	 * @return true if successful, false otherwise.
	 */
	public static boolean saveStringToFile(String fileName, String saveString) {
		boolean saved = false;
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(
					new FileWriter(fileName));
			try {
				bw.write(saveString);
				saved = true;
			}
			finally {
				bw.close();
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return saved;
	}

	/**
	 * Retrieve a string from a text file. Note that "\n" line feed
	 * is added to the end of the last line of the file.
	 * 
	 * @param fileName String name of text file
	 * @return Contents of text file (as String)
	 */
	public static String getStringFromFile(String fileName) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			br = new BufferedReader(
					new FileReader(fileName));
			
			
			try {
				String s;
				
				while ((s = br.readLine()) != null) {
					// add linefeed (\n) back since stripped by readline()
					sb.append(s + "\n"); 
				}
			}
			finally {
				br.close();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}

	public static boolean saveMyLibraryToSerialFile(String fileName,
			MyLibrary ml) {
		boolean saved = false;
		try {
	 		ObjectOutputStream oos = 
	 			new ObjectOutputStream(
	 				new BufferedOutputStream(
	 						new FileOutputStream(fileName)));
	 		try {
	 			oos.writeObject(ml);
	 			saved = true;
	 		} finally {
	 			oos.close();
	 		}
	 	} catch (Exception ex) {
	 		ex.printStackTrace();
	 	}

	 	return saved;
	}
	
	public static MyLibrary getMyLibraryFromSerialFile(String fileName)
	{
		MyLibrary thisLB = null;
		try {
			ObjectInputStream os = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(fileName)));
			try {
				Object obj = os.readObject();
				if (obj instanceof MyLibrary) {
					thisLB = (MyLibrary) obj;
				}
				
			} 
			finally {
				os.close();
			}

		}
		catch(Exception ex) {
			System.out.println("File not found");
		}

		return thisLB;
	}
}
