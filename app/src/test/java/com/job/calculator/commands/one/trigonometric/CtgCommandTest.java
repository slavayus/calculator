package com.job.calculator.commands.one.trigonometric;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * Test for the CtgCommand class
 */
public class CtgCommandTest {
    private CtgCommand ctgCommandInDegrees;
    private CtgCommand ctgCommandInRadians;

    @Before
    public void initialise() {
        ctgCommandInDegrees = new CtgCommand(true);
        ctgCommandInRadians = new CtgCommand(false);
    }

    @Test
    public void executeRadians() throws Exception {
        double result = ctgCommandInRadians.execute(5);
        assertEquals(-0.295812, result, 0.000001);

        result = ctgCommandInRadians.execute(0);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = ctgCommandInRadians.execute(-5);
        assertEquals(0.295812, result, 0.000001);

        result = ctgCommandInRadians.execute(-0);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = ctgCommandInRadians.execute(Double.MAX_VALUE);
        assertEquals(-201.530995, result, 0.000001);

        result = ctgCommandInRadians.execute(Double.MIN_VALUE);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = ctgCommandInRadians.execute(11);
        assertEquals(-0.004425, result, 0.000001);

        result = ctgCommandInRadians.execute(115);
        assertEquals(-0.344613, result, 0.000001);

        result = ctgCommandInRadians.execute(1);
        assertEquals(0.642092, result, 0.000001);

        result = ctgCommandInRadians.execute(-1);
        assertEquals(-0.642092, result, 0.000001);
    }


    @Test
    public void executeDegrees() throws Exception {
        double result = ctgCommandInDegrees.execute(5);
        assertEquals(11.430052, result, 0.000001);

        result = ctgCommandInDegrees.execute(0);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = ctgCommandInDegrees.execute(-5);
        assertEquals(-11.430052, result, 0.000001);

        result = ctgCommandInDegrees.execute(-0);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = ctgCommandInDegrees.execute(Double.MAX_VALUE);
        assertEquals(-0.399861, result, 0.000001);

        result = ctgCommandInDegrees.execute(Double.MIN_VALUE);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.000001);

        result = ctgCommandInDegrees.execute(11);
        assertEquals(5.144554, result, 0.000001);

        result = ctgCommandInDegrees.execute(115);
        assertEquals(-0.466307, result, 0.000001);

        result = ctgCommandInDegrees.execute(1);
        assertEquals(57.289961, result, 0.000001);

        result = ctgCommandInDegrees.execute(-1);
        assertEquals(-57.289961, result, 0.000001);
    }

    @Test
    public void toStringTest() throws Exception {
        Field result = CtgCommand.class.getDeclaredField("mResult");
        Field currentNumber = CtgCommand.class.getDeclaredField("mCurrentNumber");
        result.setAccessible(true);
        currentNumber.setAccessible(true);
        result.set(ctgCommandInDegrees, 3d);

        String actual = ctgCommandInDegrees.toString();
        String expected = "ctg(0.0\u00B0)\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(ctgCommandInDegrees, 4d);
        actual = ctgCommandInDegrees.toString();
        expected = "ctg(4.0\u00B0)\n = 3.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(ctgCommandInDegrees, 123d);
        result.set(ctgCommandInDegrees, 123d);
        actual = ctgCommandInDegrees.toString();
        expected = "ctg(123.0\u00B0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(ctgCommandInDegrees, Double.NEGATIVE_INFINITY);
        result.set(ctgCommandInDegrees, 123d);
        actual = ctgCommandInDegrees.toString();
        expected = "ctg(-Infinity\u00B0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(ctgCommandInDegrees, Double.POSITIVE_INFINITY);
        actual = ctgCommandInDegrees.toString();
        expected = "ctg(-Infinity\u00B0)\n = Infinity\n\n ";
        assertEquals(actual, expected);


        currentNumber.set(ctgCommandInRadians, 564d);
        actual = ctgCommandInRadians.toString();
        expected = "ctg(564.0)\n = 0.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(ctgCommandInRadians, 564d);
        actual = ctgCommandInRadians.toString();
        expected = "ctg(564.0)\n = 0.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(ctgCommandInRadians, 123d);
        result.set(ctgCommandInRadians, 123d);
        actual = ctgCommandInRadians.toString();
        expected = "ctg(123.0)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        currentNumber.set(ctgCommandInRadians, Double.NEGATIVE_INFINITY);
        result.set(ctgCommandInRadians, 123d);
        actual = ctgCommandInRadians.toString();
        expected = "ctg(-Infinity)\n = 123.0\n\n ";
        assertEquals(actual, expected);

        result.set(ctgCommandInRadians, Double.POSITIVE_INFINITY);
        actual = ctgCommandInRadians.toString();
        expected = "ctg(-Infinity)\n = Infinity\n\n ";
        assertEquals(actual, expected);
    }

}