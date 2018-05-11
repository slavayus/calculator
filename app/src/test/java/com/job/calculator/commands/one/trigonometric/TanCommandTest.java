package com.job.calculator.commands.one.trigonometric;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Test for the CosCommand class
 */
public class TanCommandTest {
    private TanCommand tanCommandInDegrees;
    private TanCommand tanCommandInRadians;

    @Before
    public void initialise() {
        tanCommandInDegrees = new TanCommand(true);
        tanCommandInRadians = new TanCommand(false);
    }

    @Test
    public void executeRadians() throws Exception {
        double result = tanCommandInRadians.execute(5);
        assertEquals(-3.380515, result, 0.000001);

        result = tanCommandInRadians.execute(0);
        assertEquals(0, result, 0.000001);

        result = tanCommandInRadians.execute(-5);
        assertEquals(3.380515, result, 0.000001);

        result = tanCommandInRadians.execute(-0);
        assertEquals(0, result, 0.000001);

        result = tanCommandInRadians.execute(Double.MAX_VALUE);
        assertEquals(-0.004962, result, 0.000001);

        result = tanCommandInRadians.execute(Double.MIN_VALUE);
        assertEquals(4.9E-324, result, 0.000001);

        result = tanCommandInRadians.execute(11);
        assertEquals(-225.950846, result, 0.000001);

        result = tanCommandInRadians.execute(115);
        assertEquals(-2.901801, result, 0.000001);

        result = tanCommandInRadians.execute(1);
        assertEquals(1.557407, result, 0.000001);

        result = tanCommandInRadians.execute(-1);
        assertEquals(-1.557407, result, 0.000001);
    }

    @Test
    public void executeDegrees() throws Exception {
        double result = tanCommandInDegrees.execute(5);
        assertEquals(0.087488, result, 0.000001);

        result = tanCommandInDegrees.execute(0);
        assertEquals(0, result, 0.000001);

        result = tanCommandInDegrees.execute(-5);
        assertEquals(-0.087488, result, 0.000001);

        result = tanCommandInDegrees.execute(-0);
        assertEquals(0, result, 0.000001);

        result = tanCommandInDegrees.execute(Double.MAX_VALUE);
        assertEquals(-2.500869, result, 0.000001);

        result = tanCommandInDegrees.execute(Double.MIN_VALUE);
        assertEquals(0, result, 0.000001);

        result = tanCommandInDegrees.execute(11);
        assertEquals(0.194380, result, 0.000001);

        result = tanCommandInDegrees.execute(115);
        assertEquals(-2.144506, result, 0.000001);

        result = tanCommandInDegrees.execute(1);
        assertEquals(0.017455, result, 0.000001);

        result = tanCommandInDegrees.execute(-1);
        assertEquals(-0.017455, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        Field result = TanCommand.class.getDeclaredField("mResult");
        Field currentNumber = TanCommand.class.getDeclaredField("mCurrentNumber");
        result.setAccessible(true);
        currentNumber.setAccessible(true);
        result.set(tanCommandInDegrees, 3d);

        String actual = tanCommandInDegrees.toString();
        String expected = "tan(0.0\u00B0)\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(tanCommandInDegrees, 4d);
        actual = tanCommandInDegrees.toString();
        expected = "tan(4.0\u00B0)\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(tanCommandInDegrees, 123d);
        result.set(tanCommandInDegrees, 123d);
        actual = tanCommandInDegrees.toString();
        expected = "tan(123.0\u00B0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(tanCommandInDegrees, Double.NEGATIVE_INFINITY);
        result.set(tanCommandInDegrees, 123d);
        actual = tanCommandInDegrees.toString();
        expected = "tan(-Infinity\u00B0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(tanCommandInDegrees, Double.POSITIVE_INFINITY);
        actual = tanCommandInDegrees.toString();
        expected = "tan(-Infinity\u00B0)\n = Infinity\n\n ";
        assertEquals(actual, expected);


        currentNumber.set(tanCommandInRadians, 564d);
        actual = tanCommandInRadians.toString();
        expected = "tan(564.0)\n = 0.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(tanCommandInRadians, 564d);
        actual = tanCommandInRadians.toString();
        expected = "tan(564.0)\n = 0.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(tanCommandInRadians, 123d);
        result.set(tanCommandInRadians, 123d);
        actual = tanCommandInRadians.toString();
        expected = "tan(123.0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(tanCommandInRadians, Double.NEGATIVE_INFINITY);
        result.set(tanCommandInRadians, 123d);
        actual = tanCommandInRadians.toString();
        expected = "tan(-Infinity)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(tanCommandInRadians, Double.POSITIVE_INFINITY);
        actual = tanCommandInRadians.toString();
        expected = "tan(-Infinity)\n = Infinity\n\n ";
        assertEquals(actual, expected);

    }

}