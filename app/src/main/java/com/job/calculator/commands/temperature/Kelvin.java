package com.job.calculator.commands.temperature;

/**
 * Class for converting to Kelvin scale
 */

public class Kelvin implements Temperature {
    private static final double T0 = 273.15;

    @Override
    public double fromCelsius(double param) {
        return param - T0;
    }

    @Override
    public double toCelsius(double param) {
        return param + T0;
    }
}
