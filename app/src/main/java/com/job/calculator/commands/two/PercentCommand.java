package com.job.calculator.commands.two;

/**
 * Class for percent command
 */

public class PercentCommand implements CommandWithTwoArgument {

    /**
     * Count the percentage of the first argument.
     *
     * @param firstArg  first argument to calculate percent
     * @param secondArg percent rate
     * @return the result of percent calculating
     */
    @Override
    public double execute(double firstArg, double secondArg) {
        return firstArg * secondArg / 100;
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
