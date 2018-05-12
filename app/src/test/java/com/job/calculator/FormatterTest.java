package com.job.calculator;

import com.job.calculator.commands.two.DivideCommand;
import com.job.calculator.commands.two.MinusCommand;
import com.job.calculator.commands.two.MullCommand;
import com.job.calculator.commands.two.PercentCommand;
import com.job.calculator.commands.two.PlusCommand;
import com.job.calculator.commands.two.RandomExponentCommand;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the Formatter class
 */
public class FormatterTest {
    @Test
    public void putComma() throws Exception {
        assertEquals("1", Formatter.putComma("1"));
        assertEquals("12", Formatter.putComma("12"));
        assertEquals("123", Formatter.putComma("123"));
        assertEquals("1,234", Formatter.putComma("1234"));
        assertEquals("12,345", Formatter.putComma("12345"));
        assertEquals("123,456", Formatter.putComma("123456"));
        assertEquals("1,234,567", Formatter.putComma("1234567"));
        assertEquals("12,345,678", Formatter.putComma("12345678"));
        assertEquals("0.0", Formatter.putComma("0.0"));
        assertEquals("0.12", Formatter.putComma("0.12"));
        assertEquals("0.123", Formatter.putComma("0.123"));
        assertEquals("0.1234", Formatter.putComma("0.1234"));
        assertEquals("0.12345", Formatter.putComma("0.12345"));
        assertEquals("0.123456", Formatter.putComma("0.123456"));
        assertEquals("12.123456", Formatter.putComma("12.123456"));
        assertEquals("123.123456", Formatter.putComma("123.123456"));
        assertEquals("1,234.123456", Formatter.putComma("1234.123456"));
        assertEquals("12,345.123456", Formatter.putComma("12345.123456"));
        assertEquals("123,456.123456", Formatter.putComma("123456.123456"));
        assertEquals("", Formatter.putComma(null));
    }

    @Test
    public void getCurrentNumberAsNumber() throws Exception {
        assertEquals(0, Formatter.getCurrentNumberAsNumber("0"), 0.000001);
        assertEquals(21.0, Formatter.getCurrentNumberAsNumber("21"), 0.000001);
        assertEquals(-21.0, Formatter.getCurrentNumberAsNumber("-21"), 0.000001);
        assertEquals(0.0, Formatter.getCurrentNumberAsNumber(null), 0.000001);
    }

    @Test
    public void getAsNewResult() throws Exception {
        String result = Formatter.getAsNewResult("YEE", 0, new MinusCommand());
        String expected = "YEE0.0\n-";
        assertEquals(result, expected);

        result = Formatter.getAsNewResult("YEE", 0, new PlusCommand());
        expected = "YEE0.0\n+";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult("YEE", 0, new DivideCommand());
        expected = "YEE0.0\n\u00F7";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult("YEE", 0, new MullCommand());
        expected = "YEE0.0\n*";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult("YEE", 0, new PercentCommand());
        expected = "YEE0.0\n%";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult("YEE", 0, new RandomExponentCommand());
        expected = "YEE0.0\n^";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult("YEE", 0, null);
        expected = "YEE0.0\n";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult("YEE", 0.01, null);
        expected = "YEE0.01\n";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult("YEE", 123123.01, null);
        expected = "YEE123,123.01\n";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult("", 123123.01, null);
        expected = "123,123.01\n";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult(null, 123123.01, null);
        expected = "123,123.01\n";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult(null, 0, null);
        expected = "0.0\n";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult(null, Double.POSITIVE_INFINITY, null);
        expected = "Infinity\n";
        assertEquals(expected, result);

        result = Formatter.getAsNewResult(null, Double.NEGATIVE_INFINITY, null);
        expected = "-Infinity\n";
        assertEquals(expected, result);
    }

    @Test
    public void getAsEqual() throws Exception {
        String result = Formatter.getAsEqual(456, "123", 0, new MinusCommand());
        String expected = "456.0\n - 123\n = 0.0\n\n ";
        assertEquals(result, expected);

        result = Formatter.getAsEqual(456, "123", 0, null);
        expected = "456.0\n  123\n = 0.0\n\n ";
        assertEquals(expected, result);

        result = Formatter.getAsEqual(0, "123123", 123123, null);
        expected = "0.0\n  123,123\n = 123,123.0\n\n ";
        assertEquals(expected, result);

        result = Formatter.getAsEqual(12123, null, 123123, null);
        expected = "12,123.0\n  \n = 123,123.0\n\n ";
        assertEquals(expected, result);

        result = Formatter.getAsEqual(Double.NEGATIVE_INFINITY, null, 123123, null);
        expected = "-Infinity\n  \n = 123,123.0\n\n ";
        assertEquals(expected, result);

        result = Formatter.getAsEqual(Double.NEGATIVE_INFINITY, null, Double.POSITIVE_INFINITY, null);
        expected = "-Infinity\n  \n = Infinity\n\n ";
        assertEquals(expected, result);
    }

}