package com.job.calculator.commands.temperature;

/**
 * Class for converting to Remyure scale
 */

public class Remyure implements Temperature {
    @Override
    public double fromCelsius(double param) {
        return param * 1.25;
    }

    @Override
    public double toCelsius(double param) {
        return param * 0.8;
    }
}
