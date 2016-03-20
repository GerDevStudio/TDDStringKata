package fr.gerdev.TDDStringKata;

/**
 * @author Gerald Returns the sum of a string containing numbers
 */
public class StringCalculator {

	public static String lineSeparator = System.lineSeparator();

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	/**
	 * Performs calculus.
	 * 
	 * User can use signle character separator '#' using //# at the beginning
	 * expression. User can use multi characters separator '###' using //[###]
	 * at the beginning expression.
	 * 
	 * @return 0 if null
	 * @return itself if unique number
	 * @return Two numbers, comma delimited, returns the sum
	 * @return Two numbers, newline delimited, returns the sum
	 * @return Three numbers, with any separator, returns the sem
	 * @throws IllegalArgumentException
	 *             if negative numbers arguments
	 */
	public static int calculate(String expression) {

		if (expression.equals("")) {
			return 0;
		}

		expression = customSeparates(expression);

		expression = expression.replaceAll(lineSeparator, ",");
		String[] numbers = expression.split(",");

		int result = addNumbers(numbers);

		return result;
	}

	/**
	 * checks if a custom separator exists, and replace it with a coma
	 * separator. single character or multi characters separator can be
	 * detected.
	 * 
	 * @return expression cleared of custom separation declaration.
	 */
	private static String customSeparates(String expression) {
		String firstChar;
		if (expression.length() > 2 && expression.substring(0, 2).equals("//")) {

			firstChar = expression.substring(2, 3);
			String separator;

			// multi character separator processing
			if (firstChar.equals("[")) {
				
				//detecting separator
				separator = expression.substring(3, expression.indexOf(']'));
				
				//clearing expression from declaration of custom separator.
				expression = expression.substring(expression.indexOf(']')+1, expression.length());
			}
			else
			{
				separator = Character.toString(expression.charAt(2));
				expression = expression.substring(3,expression.length());
			}

			expression = expression.replaceAll(separator, ",");
		}

		return expression;
	}

	private static int addNumbers(String[] numbers) {
		int result = 0;

		for (int i = 0; i < numbers.length; i++) {
			int newNumber = Integer.parseInt(numbers[i]);

			if (newNumber < 0)
				throw new IllegalArgumentException("Arguments must be positive numbers");

			if (newNumber < 1000)
				result += newNumber;

		}
		return result;
	}

}
