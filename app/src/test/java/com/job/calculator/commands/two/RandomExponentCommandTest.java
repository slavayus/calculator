package com.job.calculator.commands.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the RandomExponentCommand class
 */
public class RandomExponentCommandTest {
    @Test
    public void execute() throws Exception {
        RandomExponentCommand randomExponentCommand = new RandomExponentCommand();
        double result = randomExponentCommand.execute(5, 2);
        assertEquals(25, result, 0.000001);

        result = randomExponentCommand.execute(0, 2);
        assertEquals(0, result, 0.000001);

        result = randomExponentCommand.execute(0, 0);
        assertEquals(1, result, 0.000001);

        result = randomExponentCommand.execute(-5, 0);
        assertEquals(1, result, 0.000001);

        result = randomExponentCommand.execute(5, 0);
        assertEquals(1, result, 0.000001);

        result = randomExponentCommand.execute(5.00000, 0.000001);
        assertEquals(1.000001, result, 0.000001);

        result = randomExponentCommand.execute(Double.POSITIVE_INFINITY, 1);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = randomExponentCommand.execute(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = randomExponentCommand.execute(Double.NEGATIVE_INFINITY, 2);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = randomExponentCommand.execute(2, Double.NEGATIVE_INFINITY);
        assertEquals(0.0, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        RandomExponentCommand randomExponentCommand = new RandomExponentCommand();
        String result = randomExponentCommand.toString();
        assertEquals("^", result);
    }

}