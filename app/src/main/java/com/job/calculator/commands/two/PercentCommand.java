package com.job.calculator.commands.two;

/**
 * Class for percent command
 */

public class PercentCommand implements CommandWithTwoArgument {

    /**
     * Count the percentage of the first argument.
     *
     * @param number  first argument to calculate percent
     * @param percent percent rate
     * @return the result of percent calculating
     */
    @Override
    public double execute(double number, double percent) {
        return number * percent / 100;
    }


    /**
     * String representation of the percent sign
     *
     * @return percent sign
     */
    @Override
    public String toString() {
        return "%";
    }
}
