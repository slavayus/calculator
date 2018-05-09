package com.job.calculator.commands.temperature;

/**
 * Class for converting to Celsius scale
 */

public class Celsius implements Temperature {
    @Override
    public double fromCelsius(double param) {
        return param;
    }

    @Override
    public double toCelsius(double param) {
        return param;
    }
}
