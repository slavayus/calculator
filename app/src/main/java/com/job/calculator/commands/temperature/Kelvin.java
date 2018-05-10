package com.job.calculator.commands.temperature;

/**
 * Class for converting to Kelvin scale
 */

public class Kelvin implements Temperature {
    private static final double T0 = 273.15;

    /**
     * Convert from Celsius to Kelvin.
     *
     * @param param degrees in Celsius scale.
     * @return degrees in Kelvin scale.
     */
    @Override
    public double fromCelsius(double param) {
        return param - T0;
    }

    /**
     * Convert from Kelvin to Celsius.
     *
     * @param param degrees in Kelvin scale.
     * @return degrees in Celsius scale.
     */
    @Override
    public double toCelsius(double param) {
        return param + T0;
    }
}
