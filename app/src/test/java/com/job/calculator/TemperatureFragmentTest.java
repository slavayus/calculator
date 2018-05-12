package com.job.calculator;

import com.job.calculator.commands.temperature.Celsius;
import com.job.calculator.commands.temperature.Fahrenheit;
import com.job.calculator.commands.temperature.Kelvin;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static junit.framework.Assert.assertEquals;

/**
 * Test for the TemperatureFragment class
 */
public class TemperatureFragmentTest {
    @Test
    public void appendChar() throws Exception {
        TemperatureFragment temperatureFragment = new TemperatureFragment();
        Field field = TemperatureFragment.class.getDeclaredField("mCurrentNumber");
        field.setAccessible(true);

        Method method = temperatureFragment.getClass().getDeclaredMethod("appendChar", char.class);
        method.setAccessible(true);

        field.set(temperatureFragment, "123");
        method.invoke(temperatureFragment, '3');
        String result = (String) field.get(temperatureFragment);
        assertEquals("1233", result);

        method.invoke(temperatureFragment, ((char) 94));
        result = (String) field.get(temperatureFragment);
        assertEquals("1233", result);

        method.invoke(temperatureFragment, '0');
        result = (String) field.get(temperatureFragment);
        assertEquals("12330", result);

        field.set(temperatureFragment, "");
        method.invoke(temperatureFragment, '3');
        result = (String) field.get(temperatureFragment);
        assertEquals("3", result);

        field.set(temperatureFragment, "");
        method.invoke(temperatureFragment, '3');
        result = (String) field.get(temperatureFragment);
        assertEquals("3", result);

        field.set(temperatureFragment, "");
        method.invoke(temperatureFragment, '0');
        result = (String) field.get(temperatureFragment);
        assertEquals("0", result);

        method.invoke(temperatureFragment, '0');
        result = (String) field.get(temperatureFragment);
        assertEquals("0", result);

        field.set(temperatureFragment, "0.");
        method.invoke(temperatureFragment, '0');
        result = (String) field.get(temperatureFragment);
        assertEquals("0.0", result);

        method.invoke(temperatureFragment, '0');
        result = (String) field.get(temperatureFragment);
        assertEquals("0.00", result);
    }

    @Test
    public void calculate() throws Exception {
        TemperatureFragment temperatureFragment = new TemperatureFragment();
        Field currentNumber = TemperatureFragment.class.getDeclaredField("mCurrentNumber");
        Field operationFrom = TemperatureFragment.class.getDeclaredField("mOperationFrom");
        Field operationTo = TemperatureFragment.class.getDeclaredField("mOperationTo");
        currentNumber.setAccessible(true);
        operationFrom.setAccessible(true);
        operationTo.setAccessible(true);

        Method method = temperatureFragment.getClass().getDeclaredMethod("calculate");
        method.setAccessible(true);

        currentNumber.set(temperatureFragment, "123");
        operationFrom.set(temperatureFragment, new Celsius());
        operationTo.set(temperatureFragment, new Fahrenheit());
        Double result = (Double) method.invoke(temperatureFragment);
        assertEquals(253.4d, result);

        operationFrom.set(temperatureFragment, new Celsius());
        operationTo.set(temperatureFragment, new Kelvin());
        result = (Double) method.invoke(temperatureFragment);
        assertEquals(396.15d, result);

        currentNumber.set(temperatureFragment, "");
        result = (Double) method.invoke(temperatureFragment);
        assertEquals(0d, result);

        currentNumber.set(temperatureFragment, "0.52");
        operationFrom.set(temperatureFragment, null);
        result = (Double) method.invoke(temperatureFragment);
        assertEquals(0d, result);

        operationFrom.set(temperatureFragment, new Celsius());
        operationTo.set(temperatureFragment, null);
        result = (Double) method.invoke(temperatureFragment);
        assertEquals(0d, result);

        operationFrom.set(temperatureFragment, null);
        result = (Double) method.invoke(temperatureFragment);
        assertEquals(0d, result);
    }
}