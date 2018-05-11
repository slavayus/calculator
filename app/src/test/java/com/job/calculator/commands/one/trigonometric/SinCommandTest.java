package com.job.calculator.commands.one.trigonometric;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Test for the SinCommand class
 */
public class SinCommandTest {
    private SinCommand sinCommandInDegrees;
    private SinCommand sinCommandInRadians;

    @Before
    public void initialise() {
        sinCommandInDegrees = new SinCommand(true);
        sinCommandInRadians = new SinCommand(false);
    }

    @Test
    public void executeRadians() throws Exception {
        double result = sinCommandInRadians.execute(5);
        assertEquals(-0.958924, result, 0.000001);

        result = sinCommandInRadians.execute(0);
        assertEquals(0, result, 0.000001);

        result = sinCommandInRadians.execute(-5);
        assertEquals(0.958924, result, 0.000001);

        result = sinCommandInRadians.execute(-0);
        assertEquals(0, result, 0.000001);

        result = sinCommandInRadians.execute(Double.MAX_VALUE);
        assertEquals(0.004961, result, 0.000001);

        result = sinCommandInRadians.execute(Double.MIN_VALUE);
        assertEquals(4.9E-324, result, 0.000001);

        result = sinCommandInRadians.execute(11);
        assertEquals(-0.999990, result, 0.000001);

        result = sinCommandInRadians.execute(115);
        assertEquals(0.945435, result, 0.000001);

        result = sinCommandInRadians.execute(1);
        assertEquals(0.841470, result, 0.000001);

        result = sinCommandInRadians.execute(-1);
        assertEquals(-0.841470, result, 0.000001);
    }

    @Test
    public void executeDegrees() throws Exception {
        double result = sinCommandInDegrees.execute(5);
        assertEquals(0.087155, result, 0.000001);

        result = sinCommandInDegrees.execute(0);
        assertEquals(0, result, 0.000001);

        result = sinCommandInDegrees.execute(-5);
        assertEquals(-0.087155, result, 0.000001);

        result = sinCommandInDegrees.execute(-0);
        assertEquals(0, result, 0.000001);

        result = sinCommandInDegrees.execute(Double.MAX_VALUE);
        assertEquals(-0.928521, result, 0.000001);

        result = sinCommandInDegrees.execute(Double.MIN_VALUE);
        assertEquals(0, result, 0.000001);

        result = sinCommandInDegrees.execute(11);
        assertEquals(0.190808, result, 0.000001);

        result = sinCommandInDegrees.execute(115);
        assertEquals(0.906307, result, 0.000001);

        result = sinCommandInDegrees.execute(1);
        assertEquals(0.017452, result, 0.000001);

        result = sinCommandInDegrees.execute(-1);
        assertEquals(-0.017452, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        Field result = SinCommand.class.getDeclaredField("mResult");
        Field currentNumber = SinCommand.class.getDeclaredField("mCurrentNumber");
        result.setAccessible(true);
        currentNumber.setAccessible(true);
        result.set(sinCommandInDegrees, 3d);

        String actual = sinCommandInDegrees.toString();
        String expected = "sin(0.0\u00B0)\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sinCommandInDegrees, 4d);
        actual = sinCommandInDegrees.toString();
        expected = "sin(4.0\u00B0)\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sinCommandInDegrees, 123d);
        result.set(sinCommandInDegrees, 123d);
        actual = sinCommandInDegrees.toString();
        expected = "sin(123.0\u00B0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sinCommandInDegrees, Double.NEGATIVE_INFINITY);
        result.set(sinCommandInDegrees, 123d);
        actual = sinCommandInDegrees.toString();
        expected = "sin(-Infinity\u00B0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(sinCommandInDegrees, Double.POSITIVE_INFINITY);
        actual = sinCommandInDegrees.toString();
        expected = "sin(-Infinity\u00B0)\n = Infinity\n\n ";
        assertEquals(actual, expected);


        currentNumber.set(sinCommandInRadians, 564d);
        actual = sinCommandInRadians.toString();
        expected = "sin(564.0)\n = 0.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sinCommandInRadians, 564d);
        actual = sinCommandInRadians.toString();
        expected = "sin(564.0)\n = 0.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sinCommandInRadians, 123d);
        result.set(sinCommandInRadians, 123d);
        actual = sinCommandInRadians.toString();
        expected = "sin(123.0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(sinCommandInRadians, Double.NEGATIVE_INFINITY);
        result.set(sinCommandInRadians, 123d);
        actual = sinCommandInRadians.toString();
        expected = "sin(-Infinity)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(sinCommandInRadians, Double.POSITIVE_INFINITY);
        actual = sinCommandInRadians.toString();
        expected = "sin(-Infinity)\n = Infinity\n\n ";
        assertEquals(actual, expected);
    }

}