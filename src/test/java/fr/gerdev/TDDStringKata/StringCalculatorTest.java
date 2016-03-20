package fr.gerdev.TDDStringKata;

import static fr.gerdev.TDDStringKata.StringCalculator.lineSeparator;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void emptyStringReturnsZero() {
		String emptyString = "";
		assertEquals(StringCalculator.calculate(emptyString), 0);
	}

	@Test
	public void oneNumberReturnsItself() {

		int number = StringCalculator.calculate("5");
		assertEquals(number, 5);

		number = StringCalculator.calculate("45");
		assertEquals(number, 45);

		number = StringCalculator.calculate("155");
		assertEquals(number, 155);
	}

	@Test
	public void twoNumbersSeparatedByComaReturnsTheSum() {
		int firstNumber = 10;
		int secondNumber = 4;
		String expression = firstNumber + "," + secondNumber;

		assertEquals(StringCalculator.calculate(expression), firstNumber + secondNumber);
	}

	@Test
	public void twoNumbersSeparatedByNewLineReturnsTheSum() {
		String expression = 10 + lineSeparator + 5;
		assertEquals(StringCalculator.calculate(expression), 15);

		expression = 154 + lineSeparator + 3;
		assertEquals(StringCalculator.calculate(expression), 157);

	}

	@Test
	public void threeNumbersSeparatedByComaOrNewLineReturnsTheSum() {
		String expression = "2,3" + System.lineSeparator() + "6";
		assertEquals(StringCalculator.calculate(expression), 11);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeNumberArgumentThrowsException() {
		StringCalculator.calculate("-6");
	}
	
	@Test
	public void numbersGreaterThen1000AreIgnored(){
		assertEquals(StringCalculator.calculate("1000,1,1001,2,3"),6);
	}
	
	@Test
	public void customSeparatorDeclarationUsingDoubleSlashAtStartOfExpressionIsPossible(){
		assertEquals(StringCalculator.calculate("//#1#6,8"),15);
	}
	
	@Test
	public void multiCharacterCustomSeparatorDeclarationUsingDoubleSlashAtStartOfExpressionBetweenBracketsIsPossible(){
		assertEquals(StringCalculator.calculate("//[!!!!]1!!!!6,8"),15);
	}
}
