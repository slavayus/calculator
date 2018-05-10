package com.job.calculator.commands.temperature;

/**
 * Class for converting to Remyure scale
 */

public class Remyure implements Temperature {

    /**
     * Convert from Celsius to Remyure.
     *
     * @param param degrees in Celsius scale.
     * @return degrees in Remyure scale.
     */
    @Override
    public double fromCelsius(double param) {
        return param * 1.25;
    }

    /**
     * Convert from Remyure to Celsius.
     *
     * @param param degrees in Remyure scale.
     * @return degrees in Celsius scale.
     */
    @Override
    public double toCelsius(double param) {
        return param * 0.8;
    }
}
