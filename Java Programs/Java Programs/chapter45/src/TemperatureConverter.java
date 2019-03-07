
public class TemperatureConverter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp = 20;
		TemperatureConverter tc = new TemperatureConverter();
		
		System.out.println("" + temp + " deg C is " +
				tc.convertTemp(temp,'F') + " deg F");
		System.out.println("" + temp + " deg F is " +
				tc.convertTemp(temp,'C') + " deg C");
	}
	
	public String convertTemp(int temperature
			, char convertTo)
	{
		int value = 0;
		
		if ( convertTo == 'F' )
		{
			value = ((temperature * 9) / 5 ) + 32;
		}
		else 
		{
			value = (( temperature - 32 ) * 5) / 9;
		}
		return "" + value;
	}

}
