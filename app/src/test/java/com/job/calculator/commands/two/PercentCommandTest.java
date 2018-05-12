package com.job.calculator.commands.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the PercentCommand class
 */
public class PercentCommandTest {
    @Test
    public void execute() throws Exception {
        PercentCommand percentCommand = new PercentCommand();
        double result = percentCommand.execute(5, 2);
        assertEquals(0.1, result, 0.000001);

        result = percentCommand.execute(0, 2);
        assertEquals(0, result, 0.000001);

        result = percentCommand.execute(0, 0);
        assertEquals(0, result, 0.000001);

        result = percentCommand.execute(-5, 0);
        assertEquals(0, result, 0.000001);

        result = percentCommand.execute(5, 0);
        assertEquals(0, result, 0.000001);

        result = percentCommand.execute(5, 100);
        assertEquals(5, result, 0.000001);

        result = percentCommand.execute(5, 1);
        assertEquals(0.05, result, 0.000001);

        result = percentCommand.execute(Double.POSITIVE_INFINITY, 1);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = percentCommand.execute(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = percentCommand.execute(Double.NEGATIVE_INFINITY, 2);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.000001);

        result = percentCommand.execute(2, Double.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        PercentCommand percentCommand = new PercentCommand();
        String result = percentCommand.toString();
        assertEquals("%", result);
    }

}