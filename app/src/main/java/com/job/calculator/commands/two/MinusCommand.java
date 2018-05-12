package com.job.calculator.commands.two;

/**
 * Class for minus command
 */

public class MinusCommand implements CommandWithTwoArgument {

    /**
     * Subtracts the second argument from the first.
     *
     * @param minuend    first argument from which will be subtracted
     * @param subtrahend second argument that we subtract
     * @return the result of subtracting
     */
    @Override
    public double execute(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    /**
     * String representation of the subtract sign
     *
     * @return subtract sign
     */
    @Override
    public String toString() {
        return "-";
    }
}
