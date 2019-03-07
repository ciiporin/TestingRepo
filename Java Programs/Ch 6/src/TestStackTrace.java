
public class TestStackTrace {

	TestStackTrace(){
		divideByZero();
		
	}
	int divideByZero(){
		return 25/0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestStackTrace();
	}

}
