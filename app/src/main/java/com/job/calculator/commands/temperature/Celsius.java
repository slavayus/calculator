package com.job.calculator.commands.temperature;

/**
 * Class for converting to Celsius scale
 */

public class Celsius implements Temperature {

    /**
     * Convert from Celsius to Celsius. In this implementation just returns the given param.
     *
     * @param param degrees in Celsius scale.
     * @return degrees in Celsius scale.
     */
    @Override
    public double fromCelsius(double param) {
        return param;
    }

    /**
     * Convert from Celsius to Celsius. In this implementation just returns the given param.
     *
     * @param param degrees in Celsius scale.
     * @return degrees in Celsius scale.
     */
    @Override
    public double toCelsius(double param) {
        return param;
    }
}
