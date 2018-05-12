package com.job.calculator.commands.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the DivideCommand class
 */
public class DivideCommandTest {
    @Test
    public void execute() throws Exception {
        DivideCommand divideCommand = new DivideCommand();
        double result = divideCommand.execute(5, 2);
        assertEquals(2.5, result, 0.000001);

        result = divideCommand.execute(0, 2);
        assertEquals(0.0, result, 0.000001);

        result = divideCommand.execute(0, 0);
        assertEquals(Double.NaN, result, 0.000001);

        result = divideCommand.execute(-5, 0);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.000001);

        result = divideCommand.execute(5, 0);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = divideCommand.execute(5, 1);
        assertEquals(5, result, 0.000001);

        result = divideCommand.execute(1, 2);
        assertEquals(0.5, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        DivideCommand divideCommand = new DivideCommand();
        String result = divideCommand.toString();
        assertEquals("\u00F7", result);
    }

}