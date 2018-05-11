package com.job.calculator.commands.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the MullCommand class
 */
public class MullCommandTest {
    @Test
    public void execute() throws Exception {
        MullCommand mullCommand = new MullCommand();
        double result = mullCommand.execute(5, 2);
        assertEquals(10, result, 0.000001);

        result = mullCommand.execute(0, 2);
        assertEquals(0, result, 0.000001);

        result = mullCommand.execute(0, 0);
        assertEquals(0, result, 0.000001);

        result = mullCommand.execute(-5, 0);
        assertEquals(0, result, 0.000001);

        result = mullCommand.execute(5, 0);
        assertEquals(0, result, 0.000001);

        result = mullCommand.execute(Double.POSITIVE_INFINITY, 1);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = mullCommand.execute(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = mullCommand.execute(Double.NEGATIVE_INFINITY, 2);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.000001);

        result = mullCommand.execute(2, Double.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        MullCommand mullCommand = new MullCommand();
        String result = mullCommand.toString();
        assertEquals("*", result);
    }

}