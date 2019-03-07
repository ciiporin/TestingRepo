
public class fish extends Pet{
	int currentDepth=0;

	public int dive(int howDeep){
		currentDepth=currentDepth+howDeep;
	if (currentDepth > 100){System.out.println("I'm a little fish and cannot dive below 100 feet");
	currentDepth = currentDepth - howDeep;
	} else {
		System.out.println("Diving for " +howDeep + "feet");
		System.out.println("I'm at " + currentDepth + " feet below sea level");
	}
		return currentDepth;
	}
	
	
	public String say (String something) {
		return "Dont you know fish can't talk!!";
	}
	
	}

