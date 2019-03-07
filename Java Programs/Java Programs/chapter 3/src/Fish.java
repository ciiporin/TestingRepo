public class Fish extends Pet {
	int currentDepth = 0;

	public int dive(int howDeep) {
		currentDepth = currentDepth + howDeep;
		if (currentDepth > 100) {
			System.out.println("I'm a little fish and "
					+ "cant dive below 100 feet");
			currentDepth = currentDepth - howDeep;
			System.out.println("I am currently at "+currentDepth);
		} else {
			System.out.println("Diving for " + howDeep + " feet");
			System.out.println("I am currently at "+currentDepth);

		}
		return howDeep;
	}
}