package com.job.calculator.commands.temperature;

/**
 * Class for converting to Fahrenheit scale
 */

public class Fahrenheit implements Temperature {
    @Override
    public double fromCelsius(double param) {
        return param * 9 / 5 + 32;
    }

    @Override
    public double toCelsius(double param) {
        return (param - 32) * 5 / 9;
    }
}
