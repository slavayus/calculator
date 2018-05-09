package com.job.calculator.commands.temperature;

/**
 * Class for converting to Rankin scale
 */

public class Rankin implements Temperature {
    @Override
    public double fromCelsius(double param) {
        return param * 1.8 + 491.67;
    }

    @Override
    public double toCelsius(double param) {
        return (param - 491.67) / 1.8;
    }
}
