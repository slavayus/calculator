package com.job.calculator.commands.one;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Test for the SqrtCommand class
 */
public class SqrtCommandTest {
    @Test
    public void execute() throws Exception {
        SqrtCommand sqrtCommand = new SqrtCommand();
        double result = sqrtCommand.execute(3);
        assertEquals(1.732050, result, 0.000001);

        result = sqrtCommand.execute(-3);
        assertEquals(Double.NaN, result, 0.000001);

        result = sqrtCommand.execute(0);
        assertEquals(0, result, 0.000001);

        result = sqrtCommand.execute(-0);
        assertEquals(0, result, 0.000001);

        result = sqrtCommand.execute(9);
        assertEquals(3, result, 0.000001);

        result = sqrtCommand.execute(1);
        assertEquals(1, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        SqrtCommand sqrtCommand = new SqrtCommand();

        Field result = SqrtCommand.class.getDeclaredField("mResult");
        Field currentNumber = SqrtCommand.class.getDeclaredField("mCurrentNumber");
        result.setAccessible(true);
        currentNumber.setAccessible(true);
        result.set(sqrtCommand, 3d);


        String actual = sqrtCommand.toString();
        String expected = "\u221a 0.0\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sqrtCommand, 4d);
        actual = sqrtCommand.toString();
        expected = "\u221a 4.0\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sqrtCommand, 123d);
        result.set(sqrtCommand, 123d);
        actual = sqrtCommand.toString();
        expected = "\u221a 123.0\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sqrtCommand, Double.NEGATIVE_INFINITY);
        result.set(sqrtCommand, 123d);
        actual = sqrtCommand.toString();
        expected = "\u221a -Infinity\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(sqrtCommand, Double.POSITIVE_INFINITY);
        actual = sqrtCommand.toString();
        expected = "\u221a -Infinity\n = Infinity\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sqrtCommand, -123123d);
        actual = sqrtCommand.toString();
        expected = "\u221a -123,123.0\n = Infinity\n\n ";
        assertEquals(actual, expected);
    }

}