package com.job.calculator.commands.temperature;

/**
 * Class for converting to Rankin scale
 */

public class Rankin implements Temperature {
    @Override
    public double fromCelsius(double param) {
        return (param - 491.67) * 5 / 9;
    }

    @Override
    public double toCelsius(double param) {
        return (param + 273.15) * 9 / 5;
    }
}
