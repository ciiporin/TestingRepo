/**
 * @author Yakov Fain  (www.smartdataprocessing.com)
 *
 * This is a code sample from  the book 
 * Java Programming for Kids, Parents and Grandparents.
 */
public class Pet {
 	 int age;
	 float weight;
	 float height;
	 String color;
   
	 public void sleep(){
		  System.out.println(
						"Good night, see you tomorrow");
	 }
 
	 public void eat(){
	  System.out.println(
	  "I'm eating dogfood");
	 }
	 
	 public void bark(){
	System.out.println("I'm now barking");	 
	 
	 }
	 
	 
	 public void dance() {
		 System.out.println("I'n now dancing");
	 
	 }
 
	 public String say(String aWord){
		String petResponse = "OK!! OK!! " +aWord;
		//System.out.println(petResponse);
			return petResponse; 
	 }

}
