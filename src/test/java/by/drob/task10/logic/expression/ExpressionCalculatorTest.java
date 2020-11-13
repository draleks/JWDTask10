package by.drob.task10.logic.expression;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {
    private static final ExpressionCalculator calculator = new ExpressionCalculator();
    private static final String MULTIPLICATION = "7_11_* ";
    private static final String DIVISION = "20_5_/ ";
    private static final String SUBTRACTION = "7_5_- ";
    private static final String ADDITION = "0_12_+ ";

    @Test
    public void testCalculateShouldCalculateResultMultiplyOperation() {
        final int expected = 77;
        int actual = calculator.interpretExpression(MULTIPLICATION);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldCalculateResultDivideOperation() {
        final int expected = 4;
        int actual = calculator.interpretExpression(DIVISION);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldCalculateResultMinusOperation() {
        final int expected = 2;
        int actual = calculator.interpretExpression(SUBTRACTION);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateShouldCalculateResultPlusOperation() {
        final int expected = 12;
        int actual = calculator.interpretExpression(ADDITION);
        Assert.assertEquals(expected, actual);
    }
}
