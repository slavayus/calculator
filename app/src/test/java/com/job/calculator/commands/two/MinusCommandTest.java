package com.job.calculator.commands.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the MinusCommand class
 */
public class MinusCommandTest {
    @Test
    public void execute() throws Exception {
        MinusCommand minusCommand = new MinusCommand();
        double result = minusCommand.execute(5, 2);
        assertEquals(3, result, 0.000001);

        result = minusCommand.execute(0, 2);
        assertEquals(-2, result, 0.000001);

        result = minusCommand.execute(0, 0);
        assertEquals(0, result, 0.000001);

        result = minusCommand.execute(-5, 0);
        assertEquals(-5, result, 0.000001);

        result = minusCommand.execute(5, 0);
        assertEquals(5, result, 0.000001);

        result = minusCommand.execute(Double.POSITIVE_INFINITY, 1);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = minusCommand.execute(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals(Double.NaN, result, 0.000001);

        result = minusCommand.execute(Double.NEGATIVE_INFINITY, 2);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.000001);

        result = minusCommand.execute(2, Double.NEGATIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        MinusCommand minusCommand = new MinusCommand();
        String result = minusCommand.toString();
        assertEquals("-", result);
    }

}