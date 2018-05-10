package com.job.calculator.commands.temperature;

/**
 * Class for converting to Rankin scale
 */

public class Rankin implements Temperature {

    /**
     * Convert from Celsius to Rankin.
     *
     * @param param degrees in Celsius scale.
     * @return degrees in Rankin scale.
     */
    @Override
    public double fromCelsius(double param) {
        return (param - 491.67) * 5 / 9;
    }

    /**
     * Convert from Rankin to Celsius.
     *
     * @param param degrees in Rankin scale.
     * @return degrees in Celsius scale.
     */
    @Override
    public double toCelsius(double param) {
        return (param + 273.15) * 9 / 5;
    }
}
