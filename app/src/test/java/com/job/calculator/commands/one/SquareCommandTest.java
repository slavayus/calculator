package com.job.calculator.commands.one;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Test for the SquareCommand class
 */
public class SquareCommandTest {
    @Test
    public void execute() throws Exception {
        SquareCommand squareCommand = new SquareCommand();
        double result = squareCommand.execute(3);
        assertEquals(9, result, 0.000001);

        result = squareCommand.execute(-3);
        assertEquals(9, result, 0.000001);

        result = squareCommand.execute(0);
        assertEquals(0, result, 0.000001);

        result = squareCommand.execute(-0);
        assertEquals(0, result, 0.000001);

        result = squareCommand.execute(9);
        assertEquals(81, result, 0.000001);

        result = squareCommand.execute(1);
        assertEquals(1, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        SquareCommand squareCommand = new SquareCommand();

        Field result = SquareCommand.class.getDeclaredField("mResult");
        Field currentNumber = SquareCommand.class.getDeclaredField("mCurrentNumber");
        result.setAccessible(true);
        currentNumber.setAccessible(true);
        result.set(squareCommand, 3d);

        String actual = squareCommand.toString();
        String expected = "0.0\n ^ 2 \n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(squareCommand, 4d);
        actual = squareCommand.toString();
        expected = "4.0\n ^ 2 \n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(squareCommand, 123d);
        result.set(squareCommand, 123d);
        actual = squareCommand.toString();
        expected = "123.0\n ^ 2 \n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(squareCommand, Double.NEGATIVE_INFINITY);
        result.set(squareCommand, 123d);
        actual = squareCommand.toString();
        expected = "-Infinity\n ^ 2 \n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(squareCommand, Double.POSITIVE_INFINITY);
        actual = squareCommand.toString();
        expected = "-Infinity\n ^ 2 \n = Infinity\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(squareCommand, -123123d);
        actual = squareCommand.toString();
        expected = "-123,123.0\n ^ 2 \n = Infinity\n\n ";
        assertEquals(actual, expected);
    }

}