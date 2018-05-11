package com.job.calculator.commands.one.trigonometric;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Test for the CosCommand class
 */
public class CosCommandTest {
    private CosCommand cosCommandInDegrees;
    private CosCommand cosCommandInRadians;

    @Before
    public void initialise() {
        cosCommandInDegrees = new CosCommand(true);
        cosCommandInRadians = new CosCommand(false);
    }

    @Test
    public void executeRadians() throws Exception {
        double result = cosCommandInRadians.execute(5);
        assertEquals(0.283662, result, 0.000001);

        result = cosCommandInRadians.execute(0);
        assertEquals(1, result, 0.000001);

        result = cosCommandInRadians.execute(-5);
        assertEquals(0.283662, result, 0.000001);

        result = cosCommandInRadians.execute(-0);
        assertEquals(1, result, 0.000001);

        result = cosCommandInRadians.execute(Double.MAX_VALUE);
        assertEquals(-0.999987, result, 0.000001);

        result = cosCommandInRadians.execute(Double.MIN_VALUE);
        assertEquals(1, result, 0.000001);

        result = cosCommandInRadians.execute(11);
        assertEquals(0.004425, result, 0.000001);

        result = cosCommandInRadians.execute(115);
        assertEquals(-0.325809, result, 0.000001);

        result = cosCommandInRadians.execute(1);
        assertEquals(0.540302, result, 0.000001);

        result = cosCommandInRadians.execute(-1);
        assertEquals(0.540302, result, 0.000001);
    }

    @Test
    public void executeDegrees() throws Exception {
        double result = cosCommandInDegrees.execute(5);
        assertEquals(0.996194, result, 0.000001);

        result = cosCommandInDegrees.execute(0);
        assertEquals(1, result, 0.000001);

        result = cosCommandInDegrees.execute(-5);
        assertEquals(0.996194, result, 0.000001);

        result = cosCommandInDegrees.execute(-0);
        assertEquals(1, result, 0.000001);

        result = cosCommandInDegrees.execute(Double.MAX_VALUE);
        assertEquals(0.371279, result, 0.000001);

        result = cosCommandInDegrees.execute(Double.MIN_VALUE);
        assertEquals(1, result, 0.000001);

        result = cosCommandInDegrees.execute(11);
        assertEquals(0.981627, result, 0.000001);

        result = cosCommandInDegrees.execute(115);
        assertEquals(-0.422618, result, 0.000001);

        result = cosCommandInDegrees.execute(1);
        assertEquals(0.999847, result, 0.000001);

        result = cosCommandInDegrees.execute(-1);
        assertEquals(0.999847, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        Field result = CosCommand.class.getDeclaredField("mResult");
        Field currentNumber = CosCommand.class.getDeclaredField("mCurrentNumber");
        result.setAccessible(true);
        currentNumber.setAccessible(true);
        result.set(cosCommandInDegrees, 3d);

        String actual = cosCommandInDegrees.toString();
        String expected = "cos(0.0\u00B0)\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(cosCommandInDegrees, 4d);
        actual = cosCommandInDegrees.toString();
        expected = "cos(4.0\u00B0)\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(cosCommandInDegrees, 123d);
        result.set(cosCommandInDegrees, 123d);
        actual = cosCommandInDegrees.toString();
        expected = "cos(123.0\u00B0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(cosCommandInDegrees, Double.NEGATIVE_INFINITY);
        result.set(cosCommandInDegrees, 123d);
        actual = cosCommandInDegrees.toString();
        expected = "cos(-Infinity\u00B0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(cosCommandInDegrees, Double.POSITIVE_INFINITY);
        actual = cosCommandInDegrees.toString();
        expected = "cos(-Infinity\u00B0)\n = Infinity\n\n ";
        assertEquals(actual, expected);


        currentNumber.set(cosCommandInRadians, 564d);
        actual = cosCommandInRadians.toString();
        expected = "cos(564.0)\n = 0.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(cosCommandInRadians, 564d);
        actual = cosCommandInRadians.toString();
        expected = "cos(564.0)\n = 0.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(cosCommandInRadians, 123d);
        result.set(cosCommandInRadians, 123d);
        actual = cosCommandInRadians.toString();
        expected = "cos(123.0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(cosCommandInRadians, Double.NEGATIVE_INFINITY);
        result.set(cosCommandInRadians, 123d);
        actual = cosCommandInRadians.toString();
        expected = "cos(-Infinity)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(cosCommandInRadians, Double.POSITIVE_INFINITY);
        actual = cosCommandInRadians.toString();
        expected = "cos(-Infinity)\n = Infinity\n\n ";
        assertEquals(actual, expected);

    }

}