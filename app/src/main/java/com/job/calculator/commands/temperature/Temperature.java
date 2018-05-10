package com.job.calculator.commands.temperature;

/**
 * Interface for temperature commands
 */

public interface Temperature {

    /**
     * Convert from Celsius to other scale.
     *
     * @param param degrees in Celsius scale.
     * @return degrees in other scale.
     */
    double fromCelsius(double param);

    /**
     * Convert from other scales to Celsius.
     *
     * @param param degrees in other scales.
     * @return degrees in Celsius scale.
     */
    double toCelsius(double param);
}
