
public class HelloWorld {

	/**
	 * @param args
	 */
	
	static int answer = 5;
	
	public static void output(){
		System.out.println("*****  *****  *****  *****  *****");
		System.out.println("*   *  *        *    *      *    *");
		System.out.println("*****  *****    *    *****  *****");
		System.out.println("*      *        *    *      *  *");
		System.out.println("*      *****    *    *****  *   *");
		
	}
	
	
	public static void main(String[] args) {
		if(answer == 8){
			System.out.println("Right");
		} else {
			System.out.println("Wrong");
		}
		
		System.out.println("Hello World");
		System.out.println("Goodbye World");
		output();
	}

}
