package com.job.calculator.commands.temperature;

/**
 * Class for converting to Fahrenheit scale
 */

public class Fahrenheit implements Temperature {

    /**
     * Convert from Celsius to Fahrenheit.
     *
     * @param param degrees in Celsius scale.
     * @return degrees in Fahrenheit scale.
     */
    @Override
    public double fromCelsius(double param) {
        return (param - 32) * 5 / 9;
    }

    /**
     * Convert from Fahrenheit to Celsius.
     *
     * @param param degrees in Fahrenheit scale.
     * @return degrees in Celsius scale.
     */
    @Override
    public double toCelsius(double param) {
        return param * 9 / 5 + 32;
    }
}
