package com.job.calculator.commands.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the PlusCommand class
 */
public class PlusCommandTest {
    @Test
    public void execute() throws Exception {
        PlusCommand plusCommand = new PlusCommand();
        double result = plusCommand.execute(5, 2);
        assertEquals(7, result, 0.000001);

        result = plusCommand.execute(0, 2);
        assertEquals(2, result, 0.000001);

        result = plusCommand.execute(0, 0);
        assertEquals(0, result, 0.000001);

        result = plusCommand.execute(-5, 0);
        assertEquals(-5, result, 0.000001);

        result = plusCommand.execute(5, 0);
        assertEquals(5, result, 0.000001);

        result = plusCommand.execute(5.00000, 0.000001);
        assertEquals(5.000001, result, 0.000001);

        result = plusCommand.execute(Double.POSITIVE_INFINITY, 1);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = plusCommand.execute(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = plusCommand.execute(Double.NEGATIVE_INFINITY, 2);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.000001);

        result = plusCommand.execute(2, Double.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        PlusCommand plusCommand = new PlusCommand();
        String result = plusCommand.toString();
        assertEquals("+", result);
    }

}